package fr.dawan.miseensituation.dto;

import java.io.Serializable;

public class BlocCompetencesDto implements Serializable  {

	private static final long serialVersionUID = -8424209201736605358L;

	private long id;
	
	private String titre;
	
	private int version;
	
	private String description;
	
	private long titreProfessionnelId;
	

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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BlocCompetencesDto() {
		super();
	}

	public long getTitreProfessionnelId() {
		return titreProfessionnelId;
	}

	public void setTitreProfessionnelId(long titreProfessionnelId) {
		this.titreProfessionnelId = titreProfessionnelId;
	}

	
}
