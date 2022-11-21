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

import fr.dawan.miseensituation.dto.FormationDto;
import fr.dawan.miseensituation.services.FormationService;

@RestController
@RequestMapping("/api/formation")
public class FormationController {

	@Autowired
	private FormationService formationService;
	

	@GetMapping(produces = "application/json")
	public List<FormationDto> getAll() {
		return formationService.GenericGetAll();
	}

	@GetMapping(value = "/{bcID}", produces = "application/json")
	public FormationDto getById(@PathVariable("bcID") long bcID) {
		return formationService.GenericGetById(bcID);
	}
	
	@GetMapping(value = { "/pages/{page}/{size}" }, produces = "application/json")
	public List<FormationDto> getAllByPage(@PathVariable("page") int page, @PathVariable("size") int max) {
		return formationService.getAllPages(page - 1, max, "");

	}

	// suppression
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Long> delete(@PathVariable(name = "id") long id) {
		formationService.GenericDelete(id);
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<FormationDto> save(@RequestBody FormationDto uDto) throws Exception {
		FormationDto result = formationService.GenericSaveOrUpdate(uDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping(consumes = "application/json", produces = "application/json")
	public FormationDto update(@RequestBody FormationDto uDto) {
		return formationService.GenericSaveOrUpdate(uDto);
	}
}
