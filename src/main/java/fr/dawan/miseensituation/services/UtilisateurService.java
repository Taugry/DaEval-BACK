package fr.dawan.miseensituation.services;

import java.util.List;

import fr.dawan.miseensituation.dto.LoginDto;
import fr.dawan.miseensituation.dto.LoginResponseDto;
import fr.dawan.miseensituation.dto.UtilisateurDto;

public interface UtilisateurService extends GenericService<UtilisateurDto>{

	List<UtilisateurDto> getAllPages(int page, int max, String search);

	UtilisateurDto SetUser(UtilisateurDto uDto) throws Exception;
	
	LoginResponseDto checkLogin(LoginDto loginDto) throws Exception;

	UtilisateurDto UpdateUser(UtilisateurDto uDto) throws Exception;
	
	int CountUser();
	
	long CountUserwithsearch(String search);
}
