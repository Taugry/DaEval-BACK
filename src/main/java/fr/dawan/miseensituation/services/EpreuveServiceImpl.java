package fr.dawan.miseensituation.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.dawan.miseensituation.dto.DtoTools;
import fr.dawan.miseensituation.dto.EpreuveDto;
import fr.dawan.miseensituation.entities.Epreuve;
import fr.dawan.miseensituation.repositories.EpreuveRepository;

@Service
@Transactional
public class EpreuveServiceImpl extends GenericServiceImpl<Epreuve, EpreuveDto> implements EpreuveService {

	public EpreuveServiceImpl(EpreuveRepository repo) {
		super(repo, Epreuve.class, EpreuveDto.class);
	}

	@Autowired
	private EpreuveRepository ERepo;

	@Override
	public List<EpreuveDto> getAllPages(int page, int max, String search) {
		List<Epreuve> eps = ERepo
				.findAllByDescriptionContainingOrTitreContaining(search, search, PageRequest.of(page, max)).get()
				.collect(Collectors.toList());

		List<EpreuveDto> result = new ArrayList<EpreuveDto>();
		for (Epreuve ep : eps) {
			result.add(DtoTools.convert(ep, EpreuveDto.class));
		}
		return result;
	}

}
