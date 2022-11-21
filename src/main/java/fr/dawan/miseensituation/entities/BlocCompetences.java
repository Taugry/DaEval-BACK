package fr.dawan.miseensituation.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class BlocCompetences implements Serializable  {
	
	private static final long serialVersionUID = 4411353736453794508L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String titre;
	
	@Version
	private int version;
	
	private String description;
	
	@ManyToOne(optional = false)
	private TitreProfessionnel titreProfessionnel;

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

	public TitreProfessionnel getTitreProfessionnel() {
		return titreProfessionnel;
	}

	public void setTitreProfessionnel(TitreProfessionnel titreProfessionnel) {
		this.titreProfessionnel = titreProfessionnel;
	}

	public BlocCompetences(long id, String titre, int version, String description,
			TitreProfessionnel titreProfessionnel) {
		super();
		this.id = id;
		this.titre = titre;
		this.version = version;
		this.description = description;
		this.titreProfessionnel = titreProfessionnel;
	}
	
	public BlocCompetences() {
		super();
	}
}
