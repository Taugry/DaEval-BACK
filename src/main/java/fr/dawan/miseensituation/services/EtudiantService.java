package fr.dawan.miseensituation.services;

import java.util.List;

import fr.dawan.miseensituation.dto.EtudiantDto;

public interface EtudiantService extends GenericService<EtudiantDto>{

	List<EtudiantDto> getAllPages(int i, int max, String string);

	//EtudiantDto SaveEtudiant(EtudiantDto uDto) throws Exception;

	EtudiantDto SaveOrUpdateEtudiant(EtudiantDto uDto) throws Exception;

}
