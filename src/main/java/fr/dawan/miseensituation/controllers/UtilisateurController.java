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

import fr.dawan.miseensituation.dto.UtilisateurDto;
import fr.dawan.miseensituation.services.UtilisateurService;

@RestController
@RequestMapping("/api/user")
public class UtilisateurController {

	@Autowired
	private UtilisateurService utilisateurService;

	@GetMapping(produces = "application/json")
	public List<UtilisateurDto> getAll() {
		return utilisateurService.GenericGetAll();
	}

	@GetMapping(value = { "/pages/{page}/{size}","/pages/{page}/{size}/{search}" }, produces = "application/json")
	public List<UtilisateurDto> getAllByPage(
			@PathVariable("page") int page, 
			@PathVariable("size") int max,
			@PathVariable(value="search",required = false) Optional<String> searchOPT) {
		if(searchOPT.isPresent()) {
			return utilisateurService.getAllPages(page - 1, max, searchOPT.get());
		}
		return utilisateurService.getAllPages(page - 1, max, "");

	}
	
	@GetMapping(value = { "/count" }, produces = "application/json")
	public int countUser() {
		return utilisateurService.CountUser();

	}
	
	@GetMapping(value = { "/count/{search}" }, produces = "application/json")
	public long countUserWithSearch(@PathVariable("search") String search) {
		return utilisateurService.CountUserwithsearch(search);
	}

	@GetMapping(value = "/{bcID}", produces = "application/json")
	public UtilisateurDto getById(@PathVariable("bcID") long bcID) {
		return utilisateurService.GenericGetById(bcID);
	}

	// suppression
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Long> delete(@PathVariable(name = "id") long id) {
		utilisateurService.GenericDelete(id);
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<UtilisateurDto> save(@RequestBody UtilisateurDto uDto) throws Exception {
		uDto = utilisateurService.SetUser(uDto);
		UtilisateurDto result = utilisateurService.GenericSaveOrUpdate(uDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping(consumes = "application/json", produces = "application/json")
	public UtilisateurDto update(@RequestBody UtilisateurDto uDto) throws Exception {
		System.out.println(uDto);
		uDto = utilisateurService.UpdateUser(uDto);
		return utilisateurService.GenericSaveOrUpdate(uDto);
	}
}
