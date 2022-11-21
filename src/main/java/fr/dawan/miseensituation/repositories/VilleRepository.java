package fr.dawan.miseensituation.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.dawan.miseensituation.entities.Ville;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Long>{

	Page<Ville> findAllByNomContainingOrSlugContaining(
			String nom, String slug, Pageable pageable);
	
	@Query("SELECT COUNT(*) FROM Ville")
	int CountVilleQuery();
	
	long countByNomContaining(String nom);
}
