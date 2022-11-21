package fr.dawan.miseensituation.services;

import java.util.List;

import fr.dawan.miseensituation.dto.FormationDto;

public interface FormationService extends GenericService<FormationDto>{

	List<FormationDto> getAllPages(int page, int max, String search);
}
