package fr.dawan.miseensituation.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.miseensituation.dto.DtoTools;
import fr.dawan.miseensituation.dto.PromotionDto;
import fr.dawan.miseensituation.entities.Etudiant;
import fr.dawan.miseensituation.entities.Promotion;
import fr.dawan.miseensituation.repositories.EtudiantRepository;
import fr.dawan.miseensituation.repositories.PromotionRepository;

@Service
@Transactional
public class PromotionServiceImpl extends GenericServiceImpl<Promotion,PromotionDto> implements PromotionService{

	public PromotionServiceImpl(PromotionRepository repo) {
		super(repo, Promotion.class, PromotionDto.class);
	}
	
	@Autowired
	private PromotionRepository PRepo;
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Override
	public PromotionDto SavePromotion(PromotionDto uDto) {
		Promotion promo = DtoTools.convert(uDto, Promotion.class);
		if(uDto.getEtudiantsId()!=null) {
			for (long id : uDto.getEtudiantsId()) {
				Etudiant etu = etudiantRepository.findById(id).get();
				promo.getEtudiants().add(etu);
				etu.getPromotions().add(promo);
                promo.getEtudiants().remove(null);
			}
         
		}
		promo = PRepo.saveAndFlush(promo);
		return DtoTools.convert(promo, PromotionDto.class);
	}
	
	@Override
	public PromotionDto saveOrUpdate(PromotionDto uDto) throws Exception {
		Promotion promo = DtoTools.convert(uDto, Promotion.class);
		if (uDto.getEtudiantsId() != null) {
			for (long id : uDto.getEtudiantsId()) {
				Optional<Etudiant> opt = etudiantRepository.findById(id);
				if (opt.isPresent()) {
					Etudiant etu = opt.get();
					promo.getEtudiants().add(etu);
					etu.getPromotions().add(promo);
				}
				promo.getEtudiants().remove(null);
			}
		}
		promo = PRepo.saveAndFlush(promo);
		return DtoTools.convert(promo, PromotionDto.class);
	}
	

}
