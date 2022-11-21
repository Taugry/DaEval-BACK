package fr.dawan.miseensituation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.dawan.miseensituation.entities.Positionnement;

@Repository
public interface PositionnementRepository extends JpaRepository<Positionnement, Long> {

	@Query("FROM Positionnement p JOIN p.etudiant etu JOIN FETCH etu.promotions promo WHERE etu.id=:etudiantId AND promo.id= :promotionId")
	List<Positionnement> getAllByEtudiantAndPromo(@Param("etudiantId") long etudiantId, @Param("promotionId") long promotionId);

	@Query("FROM Positionnement p WHERE p.etudiant.id=:etudiantId AND p.intervention.id= :interventionId")
	Positionnement getByEtudiantAndIntervention(@Param("etudiantId") long etudiantId, @Param("interventionId") long interventionId);
	
	@Query("FROM Positionnement p JOIN p.etudiant etu JOIN FETCH etu.promotions promo WHERE promo.id= :promotionId")
	List<Positionnement> findAllByPromotionId(@Param("promotionId") long promotionId);
	
}
