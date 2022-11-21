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

import fr.dawan.miseensituation.dto.EvaluationDto;
import fr.dawan.miseensituation.services.EvaluationService;

@RestController
@RequestMapping("/api/eval")
public class EvaluationController {

	@Autowired
	private EvaluationService evaluationService;

	@GetMapping(produces = "application/json")
	public List<EvaluationDto> getAll() {
		return evaluationService.GenericGetAll();
	}

	@GetMapping(value = "/{evalID}", produces = "application/json")
	public EvaluationDto getById(@PathVariable("evalID") long evalID) {
		return evaluationService.GenericGetById(evalID);
	}

	// suppression
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Long> delete(@PathVariable(name = "id") long id) {
		evaluationService.GenericDelete(id);
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<EvaluationDto> save(@RequestBody EvaluationDto uDto) {
		EvaluationDto result = evaluationService.GenericSaveOrUpdate(uDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping(consumes = "application/json", produces = "application/json")
	public EvaluationDto update(@RequestBody EvaluationDto uDto) {
		return evaluationService.GenericSaveOrUpdate(uDto);
	}

	@GetMapping(value = "/etudiant/{eID}/{bcID}", produces = "application/json")
	public double getMoyenne_etudiant(@PathVariable("eID") long eID, @PathVariable("bcID") long bcID) {
		return evaluationService.moyenne_etudiant(eID, bcID);
	}

	@GetMapping(value = "/etudiant/generale/{eID}", produces = "application/json")
	public double getMoyenne_etudiant(@PathVariable("eID") long eID) {
		return evaluationService.moyenne_etudiant_generale(eID);
	}

	@GetMapping(value = "/promotion/{pID}/{bcID}", produces = "application/json")
	public double getMoyenne_promotion(@PathVariable("pID") long pID, @PathVariable("bcID") long bcID) {
		return evaluationService.moyenne_promotion(pID, bcID);
	}

	@GetMapping(value = "/promotion/generale/{pID}", produces = "application/json")
	public double getMoyenne_promotion(@PathVariable("pID") long pID) {
		return evaluationService.moyenne_promotion_generale(pID);
	}
	
	@GetMapping(value = "/promotion/bloc/{pID}/{bID}", produces = "application/json")
	public double getPromoBloc(@PathVariable("pID") long pID,@PathVariable("bID") long bID) {
		return evaluationService.moyennePromotionBlocCompetences(pID, bID);
	}
	
	@GetMapping(value = "/{eid}/{pid}/bulletin", produces = "application/octet-stream")
	public ResponseEntity<Resource> generateDocById(@PathVariable("eid") long eid, @PathVariable("pid") long pid) throws Exception {

		String outputPdfPath = evaluationService.generatePdf(eid, pid);

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
