package fr.dawan.miseensituation.dto;

import org.modelmapper.ModelMapper;

public class DtoTools {
	
	private static ModelMapper myMapper = new ModelMapper();

	public static <TSource, TDestination> TDestination convert(TSource obj, Class<TDestination> clazz) {
		try {
			return myMapper.map(obj, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
