package fr.dawan.miseensituation.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Evaluation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 153620411278359981L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private double note;
	
	@Version
	private int version;
	
	@ManyToOne(optional = false)
	private Epreuve epreuve;
	
	@ManyToOne(optional = false)
	private Etudiant etudiant;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Epreuve getEpreuve() {
		return epreuve;
	}

	public void setEpreuve(Epreuve epreuve) {
		this.epreuve = epreuve;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Evaluation(long id, double note, int version, Epreuve epreuve, Etudiant etudiant) {
		super();
		this.id = id;
		this.note = note;
		this.version = version;
		this.epreuve = epreuve;
		this.etudiant = etudiant;
	}
	
	public Evaluation() {
		super();
	}
	
}
