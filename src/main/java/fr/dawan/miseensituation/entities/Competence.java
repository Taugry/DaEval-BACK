package fr.dawan.miseensituation.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Competence implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5058079172312661495L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String titre;
	
	@Version
	private int version;
	
	private String description;
	
	@ManyToOne(optional = false)
	private BlocCompetences blocCompetences;

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

	public BlocCompetences getBlocCompetences() {
		return blocCompetences;
	}

	public void setBlocCompetences(BlocCompetences blocCompetences) {
		this.blocCompetences = blocCompetences;
	}

	public Competence(long id, String titre, int version, String description, BlocCompetences blocCompetences) {
		super();
		this.id = id;
		this.titre = titre;
		this.version = version;
		this.description = description;
		this.blocCompetences = blocCompetences;
	}
	
	public Competence() {
		super();
	}
	
}
