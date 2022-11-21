package fr.dawan.miseensituation.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Ville implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5130549839491008306L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String nom;
	
	@Column(unique = true)
	private String slug;
	
	@Version
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

	public Ville(long id, String nom, String slug, int version) {
		super();
		this.id = id;
		this.nom = nom;
		this.slug = slug;
		this.version = version;
	}

	public Ville() {
		super();
	}
}
