package fr.dawan.miseensituation.controllers;

import java.util.List;

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

import fr.dawan.miseensituation.dto.EpreuveDto;
import fr.dawan.miseensituation.services.EpreuveService;

@RestController
@RequestMapping("/api/epreuve")
public class EpreuveController {

	@Autowired
	private EpreuveService epreuveService;

	@GetMapping(produces = "application/json")
	public List<EpreuveDto> getAll() {
		return epreuveService.GenericGetAll();
	}

	@GetMapping(value = { "/pages/{page}/{size}" }, produces = "application/json")
	public List<EpreuveDto> getAllByPage(@PathVariable("page") int page, @PathVariable("size") int max) {
		return epreuveService.getAllPages(page - 1, max, "");

	}

	@GetMapping(value = "/{bcID}", produces = "application/json")
	public EpreuveDto getById(@PathVariable("bcID") long bcID) {
		return epreuveService.GenericGetById(bcID);
	}

	// suppression
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Long> delete(@PathVariable(name = "id") long id) {
		epreuveService.GenericDelete(id);
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<EpreuveDto> save(@RequestBody EpreuveDto uDto) throws Exception {
		EpreuveDto result = epreuveService.GenericSaveOrUpdate(uDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping(consumes = "application/json", produces = "application/json")
	public EpreuveDto update(@RequestBody EpreuveDto uDto) {
		return epreuveService.GenericSaveOrUpdate(uDto);
	}
}
