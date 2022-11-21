package fr.dawan.miseensituation.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.dawan.miseensituation.dto.CompetenceDto;
import fr.dawan.miseensituation.dto.DtoTools;
import fr.dawan.miseensituation.entities.Competence;
import fr.dawan.miseensituation.repositories.CompetencesRepository;

@Service
@Transactional
public class CompetenceServiceImpl extends GenericServiceImpl<Competence,CompetenceDto> implements CompetenceService{

	@Autowired
	public CompetenceServiceImpl(CompetencesRepository repo) {
		super(repo, Competence.class, CompetenceDto.class);
	}
	
	@Autowired
	private CompetencesRepository CRepo;

	@Override
	public List<CompetenceDto> getAllPages(int page, int max, String search) {
		List<Competence> cs = CRepo
				.findAllByTitreContainingOrDescriptionContaining(search, search, PageRequest.of(page, max)).get()
				.collect(Collectors.toList());
		
		List<CompetenceDto> result = new ArrayList<CompetenceDto>();
		for (Competence c : cs) {
			result.add(DtoTools.convert(c, CompetenceDto.class));
		}
		return result;
	}

	@Override
	public List<CompetenceDto> findAllByBlocCompetencesId(long id) throws Exception {
		List<Competence> comp = CRepo.findAllByBlocCompetencesId(id);

		List<CompetenceDto> result = new ArrayList<CompetenceDto>();
		for (Competence u : comp) {
			result.add(DtoTools.convert(u, CompetenceDto.class));
		}
		return result;
	}
}
