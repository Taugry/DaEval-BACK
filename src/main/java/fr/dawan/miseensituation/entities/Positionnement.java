package fr.dawan.miseensituation.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Positionnement implements Serializable{

	private static final long serialVersionUID = -1926603969910174659L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Etudiant etudiant;
	
    @ManyToOne
    private Intervention intervention;
    
    @ManyToOne
    private Niveau niveauDebut;
    
    @ManyToOne
    private Niveau niveauFin;
    
    @Version 
	private int version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Intervention getIntervention() {
		return intervention;
	}

	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}

	public Niveau getNiveauDebut() {
		return niveauDebut;
	}

	public void setNiveauDebut(Niveau niveauDebut) {
		this.niveauDebut = niveauDebut;
	}

	public Niveau getNiveauFin() {
		return niveauFin;
	}

	public void setNiveauFin(Niveau niveauFin) {
		this.niveauFin = niveauFin;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Positionnement(long id, Etudiant etudiant, Intervention intervention, Niveau niveauDebut, Niveau niveauFin,
			int version) {
		super();
		this.id = id;
		this.etudiant = etudiant;
		this.intervention = intervention;
		this.niveauDebut = niveauDebut;
		this.niveauFin = niveauFin;
		this.version = version;
	}

	public Positionnement() {
		super();
	}

}
