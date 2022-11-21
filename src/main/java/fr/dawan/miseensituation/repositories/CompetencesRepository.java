package fr.dawan.miseensituation.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.dawan.miseensituation.entities.Competence;

@Repository
public interface CompetencesRepository extends JpaRepository<Competence, Long> {

	Page<Competence> findAllByTitreContainingOrDescriptionContaining(String titre, String desc, Pageable pageable);
	
	@Query("FROM Competence c WHERE c.blocCompetences.id = :BlocCompId")
	List<Competence> findAllByBlocCompetencesId(@Param("BlocCompId") long BlocCompId);
}
