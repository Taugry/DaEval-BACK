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

import fr.dawan.miseensituation.dto.EtudiantDto;
import fr.dawan.miseensituation.services.EtudiantService;

@RestController
@RequestMapping("/api/etudiant")
public class EtudiantController {

	@Autowired
	private EtudiantService etudiantService;
	

	@GetMapping(produces = "application/json")
	public List<EtudiantDto> getAll() {
		return etudiantService.GenericGetAll();
	}

	@GetMapping(value = { "/pages/{page}/{size}" }, produces = "application/json")
	public List<EtudiantDto> getAllByPage(@PathVariable("page") int page, @PathVariable("size") int max) {
		return etudiantService.getAllPages(page - 1, max, "");

	}

	@GetMapping(value = "/{bcID}", produces = "application/json")
	public EtudiantDto getById(@PathVariable("bcID") long bcID) {
		return etudiantService.GenericGetById(bcID);
	}

	// suppression
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Long> delete(@PathVariable(name = "id") long id) {
		etudiantService.GenericDelete(id);
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<EtudiantDto> save(@RequestBody EtudiantDto uDto) throws Exception {
		EtudiantDto result = etudiantService.SaveOrUpdateEtudiant(uDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping(consumes = "application/json", produces = "application/json")
	public EtudiantDto update(@RequestBody EtudiantDto uDto) throws Exception {
		return etudiantService.SaveOrUpdateEtudiant(uDto);
	}
}
