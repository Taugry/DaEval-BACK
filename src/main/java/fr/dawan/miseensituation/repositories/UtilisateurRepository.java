package fr.dawan.miseensituation.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.dawan.miseensituation.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	
	Page<Utilisateur> findAllByFirstNameContainingOrLastNameContainingOrEmailContaining(
			String firstName, String lastName, String email, Pageable pageable);
	
	@Query("FROM Utilisateur u WHERE u.email = :email")
	Utilisateur findByEmail(@Param("email") String email);
	
	@Query("SELECT COUNT(*) FROM Utilisateur")
	int CountUserQuery();
	
	long countByFirstNameContainingOrLastNameContainingOrEmailContaining
		(String firstname, String lastname, String emailD);
	
	@Query("SELECT COUNT(*) FROM Utilisateur u WHERE u.firstName LIKE %:search% OR"
			+ " u.lastName LIKE %:search2% OR u.email LIKE %:search3%")
	long countfinal(String search,String search2,String search3);
	

}
