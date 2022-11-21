package fr.dawan.miseensituation.services;

import java.util.List;

import fr.dawan.miseensituation.dto.EpreuveDto;

public interface EpreuveService extends GenericService<EpreuveDto> {

	List<EpreuveDto> getAllPages(int i, int max, String search);

}
