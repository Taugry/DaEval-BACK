package fr.dawan.miseensituation.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.dawan.miseensituation.dto.InterventionDto;
import fr.dawan.miseensituation.entities.Intervention;
import fr.dawan.miseensituation.repositories.InterventionRepository;

@Service
@Transactional
public class InterventionServiceImpl extends GenericServiceImpl<Intervention, InterventionDto> implements InterventionService {

	public InterventionServiceImpl(InterventionRepository repo) {
		super(repo, Intervention.class, InterventionDto.class);
	}

}
