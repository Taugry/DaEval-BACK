package fr.dawan.miseensituation.dto;

import java.io.Serializable;

public class FormationDto implements Serializable{

	private static final long serialVersionUID = 6052529478978791595L;

	private long id;
	
	private String titre;
	
	private int durée;
	
	private String description;//ObjetPedagogique
	
	private int version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getDurée() {
		return durée;
	}

	public void setDurée(int durée) {
		this.durée = durée;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}	
}
