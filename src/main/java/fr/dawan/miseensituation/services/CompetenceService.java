package fr.dawan.miseensituation.services;

import java.util.List;

import fr.dawan.miseensituation.dto.CompetenceDto;

public interface CompetenceService extends GenericService<CompetenceDto>{

	List<CompetenceDto> getAllPages(int page, int max, String search);
	
	List<CompetenceDto> findAllByBlocCompetencesId (long id) throws Exception;
}
