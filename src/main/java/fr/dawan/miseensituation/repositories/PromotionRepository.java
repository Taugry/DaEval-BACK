package fr.dawan.miseensituation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dawan.miseensituation.entities.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long>{
}
