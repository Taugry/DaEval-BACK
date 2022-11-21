package fr.dawan.miseensituation.dto;

import java.io.Serializable;

public class VilleDto implements Serializable {

	private static final long serialVersionUID = 4016575087030824993L;

	private long id;
	
	private String nom;
	
	private String slug;

	private int version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
	
	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public VilleDto() {
		super();
	}
}
