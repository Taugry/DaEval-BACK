package fr.dawan.miseensituation.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dawan.miseensituation.entities.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	Page<Etudiant> findAllByFirstNameContainingOrLastNameContainingOrEmailContaining(
			String firstName, String lastName, String email, Pageable pageable);
}
