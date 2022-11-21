package fr.dawan.miseensituation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.dawan.miseensituation.entities.Evaluation;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

	
	@Query("SELECT AVG(e.note) FROM Evaluation e JOIN e.etudiant etu WHERE etu.id= :etudiantId AND e.epreuve.blocCompetences.id = :blocCompetencesId")
	double RMoyenne_etudiant_BlocCompetance(@Param("etudiantId") long etudiantId,@Param("blocCompetencesId") long blocCompetencesId);

	@Query("SELECT AVG(eval.note) FROM Etudiant e INNER JOIN Evaluation eval ON e.id = eval.etudiant WHERE e.id = :eID")
	double RMoyenne_generale_etudiant(@Param("eID") long eID);

	//non obligatoire
	@Query("SELECT AVG(e.note) FROM Evaluation e JOIN e.etudiant etu JOIN etu.promotions promo WHERE promo.id= :promotionId")
	double getAvgByPromotionId(@Param("promotionId") long promotionId);
	//non obligatoire
	@Query("SELECT AVG(e.note) FROM Evaluation e JOIN e.etudiant etu JOIN etu.promotions promo WHERE etu.id= :etudiantId AND promo.id= :promotionId")
	double getAvgByEtudiantIdAndPromotionId(@Param("etudiantId") long etudiantId,@Param("promotionId") long promotionId);


	
	@Query("SELECT AVG(e.note) FROM Evaluation e JOIN e.etudiant etu JOIN etu.promotions promo WHERE promo.id= :promotionId AND e.epreuve.blocCompetences.id = :blocCompetencesId")
	double RMoyenne_promotion_BlocCompetence(@Param("promotionId") long promotionId,@Param("blocCompetencesId") long blocCompetencesId);
	 
	 @Query("SELECT AVG(e.note) FROM Evaluation e JOIN e.etudiant etu JOIN etu.promotions promo WHERE promo.id= :promotionId") 
	 double RMoyenne_generale_promotion(@Param("promotionId") long pID);


}
