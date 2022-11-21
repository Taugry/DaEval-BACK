package fr.dawan.miseensituation.services;

import java.util.List;

import fr.dawan.miseensituation.dto.VilleDto;

public interface VilleService extends GenericService<VilleDto>{

	List<VilleDto> getAllPages(int page, int max, String search);
	
	int CountVille();
	
	long CountVillewithsearch(String search);

}
