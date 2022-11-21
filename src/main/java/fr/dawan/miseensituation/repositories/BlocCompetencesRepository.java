package fr.dawan.miseensituation.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.dawan.miseensituation.entities.BlocCompetences;

@Repository
public interface BlocCompetencesRepository extends JpaRepository<BlocCompetences, Long> {

	Page<BlocCompetences> findAllByTitreContainingOrDescriptionContaining(String titre, String desc, Pageable pageable);

	@Query("FROM BlocCompetences bc WHERE bc.titreProfessionnel.id = :titreProId")
	List<BlocCompetences> findAllByTitreProfessionnelId(@Param("titreProId") long titreProId);
}
