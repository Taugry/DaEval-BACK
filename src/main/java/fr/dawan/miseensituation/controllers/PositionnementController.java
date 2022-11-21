package fr.dawan.miseensituation.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.miseensituation.dto.PositionnementDto;
import fr.dawan.miseensituation.services.PositionnementService;

@RestController
@RequestMapping("/api/position")
public class PositionnementController {
	
	@Autowired
	private PositionnementService positionnementService;
	

	@GetMapping(produces = "application/json")
	public List<PositionnementDto> getAll() {
		return positionnementService.GenericGetAll();
	}

	@GetMapping(value = "/{bcID}", produces = "application/json")
	public PositionnementDto getById(@PathVariable("bcID") long bcID) {
		return positionnementService.GenericGetById(bcID);
	}

	// suppression
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Long> delete(@PathVariable(name = "id") long id) {
		positionnementService.GenericDelete(id);
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<PositionnementDto> save(@RequestBody PositionnementDto uDto) throws Exception {
		PositionnementDto result = positionnementService.GenericSaveOrUpdate(uDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping(consumes = "application/json", produces = "application/json")
	public PositionnementDto update(@RequestBody PositionnementDto uDto) {
		return positionnementService.GenericSaveOrUpdate(uDto);
	}
	
	@GetMapping(value = "/pdf/{pid}", produces = "application/octet-stream")
	public ResponseEntity<Resource> generateDocById(@PathVariable("pid") long pid) throws Exception {

		String outputPdfPath = positionnementService.generatePdf(pid);

		File f = new File(outputPdfPath);
		Path path = Paths.get(f.getAbsolutePath());
		ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=fiche.pdf");
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=fiche.pdf");

		return ResponseEntity.ok().headers(headers).contentLength(f.length())
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
	}
}
