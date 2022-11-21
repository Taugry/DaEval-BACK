package fr.dawan.miseensituation.dto;

import java.io.Serializable;

public class TitreProfessionnelDto implements Serializable {

	private static final long serialVersionUID = -2123829577564498943L;

	private long id;
	
	private String titre;

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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public TitreProfessionnelDto(long id, String titre, int version) {
		super();
		this.id = id;
		this.titre = titre;
		this.version = version;
	}
	
	public TitreProfessionnelDto() {
		super();
	}
	
}
