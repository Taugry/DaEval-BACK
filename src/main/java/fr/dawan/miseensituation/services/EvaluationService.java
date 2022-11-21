package fr.dawan.miseensituation.services;

import fr.dawan.miseensituation.dto.EvaluationDto;

public interface EvaluationService extends GenericService<EvaluationDto> {
	
	double moyenne_etudiant (Long EtudiantID, Long BlocComID);
	
	double moyenne_etudiant_generale(Long EtudiantID);
	
	double moyenne_promotion (Long PromotionID, Long BlocComID);
	
	double moyenne_promotion_generale (Long PromotionID);
	
	double moyennePromotionBlocCompetences(Long PromotionID, Long BlocCompID);
	
	double moyenneEtudiantParBloc(Long etudiantID, Long BlocCompID);
	
	String generatePdf(long etuId, long promoId) throws Exception;
}
