package fr.dawan.miseensituation.services;

import java.util.List;

import fr.dawan.miseensituation.dto.BlocCompetencesDto;

public interface BlocCompetenceService extends GenericService<BlocCompetencesDto> {
	
	List<BlocCompetencesDto> getAllPages(int page, int max, String search);

	List<BlocCompetencesDto> findAllByTitreProfessionnelId(long id) throws Exception;
	
}
