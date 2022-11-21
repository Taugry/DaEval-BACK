package fr.dawan.miseensituation.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.dawan.miseensituation.dto.BlocCompetencesDto;
import fr.dawan.miseensituation.dto.DtoTools;
import fr.dawan.miseensituation.entities.BlocCompetences;
import fr.dawan.miseensituation.repositories.BlocCompetencesRepository;

@Service
@Transactional
public class BlocCompetenceServiceImpl extends GenericServiceImpl<BlocCompetences, BlocCompetencesDto>
		implements BlocCompetenceService {

	@Autowired
	public BlocCompetenceServiceImpl(BlocCompetencesRepository repo) {
		super(repo, BlocCompetences.class, BlocCompetencesDto.class);
	}

	@Autowired
	private BlocCompetencesRepository BCRepo;

	@Override
	public List<BlocCompetencesDto> getAllPages(int page, int max, String search) {
		List<BlocCompetences> bcs = BCRepo
				.findAllByTitreContainingOrDescriptionContaining(search, search, PageRequest.of(page, max)).get()
				.collect(Collectors.toList());
		
		List<BlocCompetencesDto> result = new ArrayList<BlocCompetencesDto>();
		for (BlocCompetences bc : bcs) {
			result.add(DtoTools.convert(bc, BlocCompetencesDto.class));
		}
		return result;
	}

	@Override
	public List<BlocCompetencesDto> findAllByTitreProfessionnelId(long titreProId) throws Exception{
		List<BlocCompetences> comp = BCRepo.findAllByTitreProfessionnelId(titreProId);

		List<BlocCompetencesDto> result = new ArrayList<BlocCompetencesDto>();
		for (BlocCompetences u : comp) {
			result.add(DtoTools.convert(u, BlocCompetencesDto.class));
		}
		return result;
	}

}
