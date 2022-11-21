package fr.dawan.miseensituation.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.miseensituation.dto.DtoTools;

public class GenericServiceImpl<inputObject, outputObject> implements GenericService<outputObject> {

	@Autowired
	private JpaRepository<inputObject, Long> repo;
	private Class<outputObject> classObjetSortie;
	private Class<inputObject> classObjetEntree;
	
	EntityManager eManager;

	@Autowired
	public GenericServiceImpl(JpaRepository<inputObject, Long> repo, Class<inputObject> entree,
			Class<outputObject> type) {
		this.repo = repo;
		this.classObjetSortie = type;
		this.classObjetEntree = entree;
	}

	@Override
	public List<outputObject> GenericGetAll() {
		return repo.findAll().stream().map(r -> DtoTools.convert(r, classObjetSortie)).collect(Collectors.toList());
	}

	@Override
	public outputObject GenericGetById(long id) {
		Optional<inputObject> u = repo.findById(id);
		if (u.isPresent())
			return DtoTools.convert(u.get(), classObjetSortie);

		return null;
	}

	@Override
	public outputObject GenericSaveOrUpdate(outputObject obj) {
		return DtoTools.convert(repo.saveAndFlush(DtoTools.convert(obj, classObjetEntree)), classObjetSortie);
	}

	@Override
	public void GenericDelete(long id) {
		repo.deleteById(id);

	}

	

}
