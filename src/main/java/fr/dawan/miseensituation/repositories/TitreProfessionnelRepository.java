package fr.dawan.miseensituation.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dawan.miseensituation.entities.TitreProfessionnel;

@Repository
public interface TitreProfessionnelRepository extends JpaRepository<TitreProfessionnel, Long>{

	 Page<TitreProfessionnel> findAllByTitreContaining(String desc, Pageable pageable);
}
