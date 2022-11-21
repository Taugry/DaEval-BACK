package fr.dawan.miseensituation.services;

import java.util.List;

import fr.dawan.miseensituation.dto.PositionnementDto;

public interface PositionnementService extends GenericService<PositionnementDto> {

	String generatePdf(long pid) throws Exception;

	List<PositionnementDto> getAllByEtudiantAndPromo(long etudiantId, long promotionId) throws Exception;

	PositionnementDto getByEtudiantAndIntervention(long etudiantId, long interventionId) throws Exception;

}
