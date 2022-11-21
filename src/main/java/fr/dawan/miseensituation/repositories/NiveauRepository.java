package fr.dawan.miseensituation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dawan.miseensituation.entities.Niveau;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long>{

}
