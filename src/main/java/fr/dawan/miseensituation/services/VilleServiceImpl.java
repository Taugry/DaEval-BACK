package fr.dawan.miseensituation.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.dawan.miseensituation.dto.DtoTools;
import fr.dawan.miseensituation.dto.VilleDto;
import fr.dawan.miseensituation.entities.Ville;
import fr.dawan.miseensituation.repositories.VilleRepository;

@Service
@Transactional
public class VilleServiceImpl extends GenericServiceImpl<Ville, VilleDto> implements VilleService {

	public VilleServiceImpl(VilleRepository repo) {
		super(repo, Ville.class, VilleDto.class);
	}

	@Autowired
	private VilleRepository VRepo;

	@Override
	public List<VilleDto> getAllPages(int page, int max, String search) {
		List<Ville> villes = VRepo.findAllByNomContainingOrSlugContaining(search, search, PageRequest.of(page, max))
				.get().collect(Collectors.toList());

		List<VilleDto> result = new ArrayList<VilleDto>();
		for (Ville v : villes) {
			result.add(DtoTools.convert(v, VilleDto.class));
		}
		return result;
	}

	@Override
	public int CountVille() {
		return VRepo.CountVilleQuery();
	}

	@Override
	public long CountVillewithsearch(String search) {
		return VRepo.countByNomContaining(search);
	}

}
