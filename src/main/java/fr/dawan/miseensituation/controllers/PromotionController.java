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

import fr.dawan.miseensituation.dto.PromotionDto;
import fr.dawan.miseensituation.services.PromotionService;

@RestController
@RequestMapping("/api/promotion")
public class PromotionController {
	
	@Autowired
	private PromotionService promotionService;
	

	@GetMapping(produces = "application/json")
	public List<PromotionDto> getAll() {
		return promotionService.GenericGetAll();
	}

	@GetMapping(value = "/{bcID}", produces = "application/json")
	public PromotionDto getById(@PathVariable("bcID") long bcID) {
		return promotionService.GenericGetById(bcID);
	}

	// suppression
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Long> delete(@PathVariable(name = "id") long id) {
		promotionService.GenericDelete(id);
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}

	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<PromotionDto> save(@RequestBody PromotionDto uDto) throws Exception {
		PromotionDto result = promotionService.SavePromotion(uDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping(consumes = "application/json", produces = "application/json")
	public PromotionDto update(@RequestBody PromotionDto uDto) throws Exception {
		return promotionService.saveOrUpdate(uDto);
	}
	

}
