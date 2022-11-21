package fr.dawan.miseensituation.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.dawan.miseensituation.dto.NiveauDto;
import fr.dawan.miseensituation.entities.Niveau;
import fr.dawan.miseensituation.repositories.NiveauRepository;

@Service
@Transactional
public class NiveauServiceImpl extends GenericServiceImpl<Niveau, NiveauDto> implements NiveauService {

	public NiveauServiceImpl(NiveauRepository repo) {
		super(repo, Niveau.class, NiveauDto.class);
		// TODO Auto-generated constructor stub
	}

}
