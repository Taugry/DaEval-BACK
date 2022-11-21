package fr.dawan.miseensituation.services;

import fr.dawan.miseensituation.dto.PromotionDto;

public interface PromotionService extends GenericService<PromotionDto>{

	PromotionDto SavePromotion(PromotionDto uDto);

	PromotionDto saveOrUpdate(PromotionDto uDto) throws Exception;

}
