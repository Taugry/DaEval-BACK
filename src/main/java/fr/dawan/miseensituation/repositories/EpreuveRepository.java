package fr.dawan.miseensituation.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dawan.miseensituation.entities.Epreuve;

@Repository
public interface EpreuveRepository extends JpaRepository<Epreuve, Long>{
	
	Page<Epreuve> findAllByDescriptionContainingOrTitreContaining(
			String desc, String titre,Pageable pageable);
}
