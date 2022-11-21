package fr.dawan.miseensituation.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Intervention implements Serializable {

	private static final long serialVersionUID = -1306359393046246950L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDate dateDebut;
	
	private LocalDate dateFin;
	
	@Version 
	int version;
	
    @ManyToOne 
    private Formation formation; 
    
    @ManyToOne 
    private Promotion promotion;
    
    @ManyToOne 
    private Utilisateur formateur;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Utilisateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Utilisateur formateur) {
		this.formateur = formateur;
	}

	public Intervention(long id, LocalDate dateDebut, LocalDate dateFin, int version, Formation formation,
			Promotion promotion, Utilisateur formateur) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.version = version;
		this.formation = formation;
		this.promotion = promotion;
		this.formateur = formateur;
	}
    
	public Intervention() {
		super();
	}
	
    
    
    

}
