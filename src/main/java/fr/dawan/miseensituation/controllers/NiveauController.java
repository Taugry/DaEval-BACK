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

import fr.dawan.miseensituation.dto.NiveauDto;
import fr.dawan.miseensituation.services.NiveauService;

@RestController
@RequestMapping("/api/niveau")
public class NiveauController {
	
	@Autowired
	private NiveauService niveauService;
	
	@GetMapping(produces = "application/json")
	public List<NiveauDto> getAll() {
		return niveauService.GenericGetAll();
	}

	@GetMapping(value = "/{bcID}", produces = "application/json")
	public NiveauDto getById(@PathVariable("bcID") long bcID) {
		return niveauService.GenericGetById(bcID);
	}

	// suppression
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Long> delete(@PathVariable(name = "id") long id) {
		niveauService.GenericDelete(id);
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<NiveauDto> save(@RequestBody NiveauDto uDto) throws Exception {
		NiveauDto result = niveauService.GenericSaveOrUpdate(uDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping(consumes = "application/json", produces = "application/json")
	public NiveauDto update(@RequestBody NiveauDto uDto) {
		return niveauService.GenericSaveOrUpdate(uDto);
	}
}
