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

import fr.dawan.miseensituation.dto.InterventionDto;
import fr.dawan.miseensituation.services.InterventionService;

@RestController
@RequestMapping("/api/inter")
public class InterventionController {
	
	@Autowired
	private InterventionService interventionService;

	@GetMapping(produces = "application/json")
	public List<InterventionDto> getAll() {
		return interventionService.GenericGetAll();
	}

	@GetMapping(value = "/{bcID}", produces = "application/json")
	public InterventionDto getById(@PathVariable("bcID") long bcID) {
		return interventionService.GenericGetById(bcID);
	}

	// suppression
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Long> delete(@PathVariable(name = "id") long id) {
		interventionService.GenericDelete(id);
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<InterventionDto> save(@RequestBody InterventionDto uDto) throws Exception {
		InterventionDto result = interventionService.GenericSaveOrUpdate(uDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping(consumes = "application/json", produces = "application/json")
	public InterventionDto update(@RequestBody InterventionDto uDto) {
		return interventionService.GenericSaveOrUpdate(uDto);
	}
}
