package fr.dawan.miseensituation.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class TitreProfessionnel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7784083961390908434L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String titre;
	
	@Version
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

	public TitreProfessionnel(long id, String titre, int version) {
		super();
		this.id = id;
		this.titre = titre;
		this.version = version;
	}
	
	public TitreProfessionnel() {
		super();
	}
}
