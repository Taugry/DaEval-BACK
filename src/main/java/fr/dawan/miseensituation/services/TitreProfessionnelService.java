package fr.dawan.miseensituation.services;

import java.util.List;

import fr.dawan.miseensituation.dto.TitreProfessionnelDto;

public interface TitreProfessionnelService extends GenericService<TitreProfessionnelDto>{
	
	List<TitreProfessionnelDto> getAllPage(int page, int max,String desc);
	
	String generatePdf(long id) throws Exception;
}
