package fr.dawan.miseensituation.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Epreuve implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8323293950498224912L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String titre;
	
	private String description;
	
	public enum Type {
		QCM, MES
	}
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Version
	private int version;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public BlocCompetences getBlocCompetences() {
		return blocCompetences;
	}

	public void setBlocCompetences(BlocCompetences blocCompetences) {
		this.blocCompetences = blocCompetences;
	}

	public Epreuve(long id, String titre, String description, Type type, int version, BlocCompetences blocCompetences) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.type = type;
		this.version = version;
		this.blocCompetences = blocCompetences;
	}
	
	public Epreuve() {
		super();
	}

	
}
