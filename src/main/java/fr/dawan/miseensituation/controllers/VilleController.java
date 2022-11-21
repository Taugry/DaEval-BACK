package fr.dawan.miseensituation.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.miseensituation.dto.VilleDto;
import fr.dawan.miseensituation.services.VilleService;

@RestController
@RequestMapping("/api/ville")
public class VilleController {
	
	@Autowired
	private VilleService villeService;

	@GetMapping(produces = "application/json")
	public List<VilleDto> getAll() {
		return villeService.GenericGetAll();
	}

	@GetMapping(value = { "/pages/{page}/{size}","/pages/{page}/{size}/{search}" }, produces = "application/json")
	public List<VilleDto> getAllByPage(
			@PathVariable("page") int page, 
			@PathVariable("size") int max,
			@PathVariable(value="search",required = false) Optional<String> searchOPT) {
		if(searchOPT.isPresent()) {
			return villeService.getAllPages(page - 1, max, searchOPT.get());
		}
		return villeService.getAllPages(page - 1, max,"");

	}
	
	@GetMapping(value = { "/count" }, produces = "application/json")
	public int countVille() {
		return villeService.CountVille();

	}
	
	@GetMapping(value = { "/count/{search}" }, produces = "application/json")
	public long countVilleWithSearch(@PathVariable("search") String search) {
		return villeService.CountVillewithsearch(search);
	}

	@GetMapping(value = "/{vID}", produces = "application/json")
	public VilleDto getById(@PathVariable("vID") long vID) {
		return villeService.GenericGetById(vID);
	}

	// suppression
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Long> delete(@PathVariable(name = "id") long id) {
		villeService.GenericDelete(id);
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<VilleDto> save(@RequestBody VilleDto uDto) throws Exception {
		VilleDto result = villeService.GenericSaveOrUpdate(uDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping(consumes = "application/json", produces = "application/json")
	public VilleDto update(@RequestBody VilleDto uDto) {
		return villeService.GenericSaveOrUpdate(uDto);
	}

}
