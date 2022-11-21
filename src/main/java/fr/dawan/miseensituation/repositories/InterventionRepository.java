package fr.dawan.miseensituation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dawan.miseensituation.entities.Intervention;

@Repository
public interface InterventionRepository extends JpaRepository<Intervention, Long>{

}
