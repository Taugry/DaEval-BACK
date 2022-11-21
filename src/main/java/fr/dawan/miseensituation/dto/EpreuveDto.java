package fr.dawan.miseensituation.dto;

import java.io.Serializable;

public class EpreuveDto implements Serializable {

	private static final long serialVersionUID = -2061957051763865479L;

	private long id;
	
	private String titre;
	
	private String description;
	
	private String type;

	private int version;
	
	private long blocCompetencesId;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}



	public EpreuveDto() {
		super();
	}

	public long getBlocCompetencesId() {
		return blocCompetencesId;
	}

	public void setBlocCompetencesId(long blocCompetencesId) {
		this.blocCompetencesId = blocCompetencesId;
	}

	
	
}
