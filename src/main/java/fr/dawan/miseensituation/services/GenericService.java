package fr.dawan.miseensituation.services;

import java.util.List;


public interface GenericService <T> {
	
	List<T> GenericGetAll();
	
	T GenericGetById(long id);

	T GenericSaveOrUpdate(T tDto);

	void GenericDelete(long id);
	
}
