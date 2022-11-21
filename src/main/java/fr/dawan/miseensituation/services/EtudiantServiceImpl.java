package fr.dawan.miseensituation.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.dawan.miseensituation.dto.DtoTools;
import fr.dawan.miseensituation.dto.EtudiantDto;
import fr.dawan.miseensituation.entities.Etudiant;
import fr.dawan.miseensituation.entities.Promotion;
import fr.dawan.miseensituation.repositories.EtudiantRepository;
import fr.dawan.miseensituation.repositories.PromotionRepository;
import fr.dawan.miseensituation.tools.HashTools;

@Service
@Transactional
public class EtudiantServiceImpl extends GenericServiceImpl<Etudiant,EtudiantDto> implements EtudiantService{

	public EtudiantServiceImpl(EtudiantRepository repo) {
		super(repo, Etudiant.class, EtudiantDto.class);
	}
	
	@Autowired
	private EtudiantRepository ERepo;
	
	@Autowired
	private PromotionRepository promotionRepository;
	
	@Override
	public List<EtudiantDto> getAllPages(int page, int max, String search) {
		List<Etudiant> users = ERepo.findAllByFirstNameContainingOrLastNameContainingOrEmailContaining(search,
				search, search, PageRequest.of(page, max)).get().collect(Collectors.toList());

		List<EtudiantDto> result = new ArrayList<EtudiantDto>();
		for (Etudiant u : users) {
			result.add(DtoTools.convert(u, EtudiantDto.class));
		}
		return result;
	}

	@Override
	public EtudiantDto SaveOrUpdateEtudiant(EtudiantDto uDto) throws Exception {
		uDto.setPassword(HashTools.hashSHA512(uDto.getPassword()));
		uDto.setRole("ETUDIANT");
		uDto.setActive(true);
		
		Etudiant u = DtoTools.convert(uDto, Etudiant.class);
		if(uDto.getPromotionsId()!=null) {
			for (long id : uDto.getPromotionsId()) {
				Optional<Promotion> opt = promotionRepository.findById(id);
				if(opt.isPresent()) {
					Promotion promo = opt.get();
					u.getPromotions().add(promo);
					promo.getEtudiants().add(u);
				}
				u.getPromotions().remove(null);
			}			
		}
		u = ERepo.saveAndFlush(u);
		return DtoTools.convert(u, EtudiantDto.class);
	}
}
