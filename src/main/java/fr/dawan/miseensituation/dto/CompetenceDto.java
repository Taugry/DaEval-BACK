package fr.dawan.miseensituation.dto;

import java.io.Serializable;

public class CompetenceDto implements Serializable {

	private static final long serialVersionUID = 2989599267433847123L;

	private long id;
	
	private String titre;
	
	private int version;
	
	private String description;
	
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

	public CompetenceDto() {
		super();
	}

	public long getBlocCompetencesId() {
		return blocCompetencesId;
	}

	public void setBlocCompetencesId(long blocCompetencesId) {
		this.blocCompetencesId = blocCompetencesId;
	}

}
