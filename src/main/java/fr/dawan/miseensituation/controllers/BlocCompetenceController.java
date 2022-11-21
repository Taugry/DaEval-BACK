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

import fr.dawan.miseensituation.dto.BlocCompetencesDto;
import fr.dawan.miseensituation.services.BlocCompetenceService;

@RestController
@RequestMapping("/api/bc")
public class BlocCompetenceController {
	
	@Autowired
	private BlocCompetenceService blocCompetenceService;

	@GetMapping(produces = "application/json")
	public List<BlocCompetencesDto> getAll() {
		return blocCompetenceService.GenericGetAll();
	}

	@GetMapping(value = { "/pages/{page}/{size}" }, produces = "application/json")
	public List<BlocCompetencesDto> getAllByPage(@PathVariable("page") int page, @PathVariable("size") int max) {
		return blocCompetenceService.getAllPages(page - 1, max, "");

	}

	@GetMapping(value = "/{bcID}", produces = "application/json")
	public BlocCompetencesDto getById(@PathVariable("bcID") long bcID) {
		return blocCompetenceService.GenericGetById(bcID);
	}

	// suppression
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Long> delete(@PathVariable(name = "id") long id) {
		blocCompetenceService.GenericDelete(id);
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<BlocCompetencesDto> save(@RequestBody BlocCompetencesDto uDto) {
		BlocCompetencesDto result = blocCompetenceService.GenericSaveOrUpdate(uDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping(consumes = "application/json", produces = "application/json")
	public BlocCompetencesDto update(@RequestBody BlocCompetencesDto uDto) {
		return blocCompetenceService.GenericSaveOrUpdate(uDto);
	}
}
