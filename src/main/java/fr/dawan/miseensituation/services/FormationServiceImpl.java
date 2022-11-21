package fr.dawan.miseensituation.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.dawan.miseensituation.dto.DtoTools;
import fr.dawan.miseensituation.dto.FormationDto;
import fr.dawan.miseensituation.entities.Formation;
import fr.dawan.miseensituation.repositories.FormationRepository;

@Service
@Transactional
public class FormationServiceImpl extends GenericServiceImpl<Formation, FormationDto> implements FormationService {

	@Autowired
	private FormationRepository fRepo;

	public FormationServiceImpl(FormationRepository repo) {
		super(repo, Formation.class, FormationDto.class);
	}

	@Override
	public List<FormationDto> getAllPages(int page, int max, String search) {
		List<Formation> formations = fRepo
				.findAllByTitreContainingOrDescriptionContaining(search, search, PageRequest.of(page, max)).get()
				.collect(Collectors.toList());

		List<FormationDto> result = new ArrayList<FormationDto>();
		for (Formation f : formations) {
			result.add(DtoTools.convert(f, FormationDto.class));
		}
		return result;
	}

}
