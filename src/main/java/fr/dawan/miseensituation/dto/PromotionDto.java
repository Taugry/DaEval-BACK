package fr.dawan.miseensituation.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class PromotionDto implements Serializable {

	private static final long serialVersionUID = -6220031501187491474L;

	private long id;
	
	LocalDate dateDebut;
	
	LocalDate dateFin;

	private int version;

	private long titreProfessionnelId;
	
	private String titreProfessionnelTitre;

	private long villeId;
	
	private String villeNom;
	
	private List<Long> etudiantsId;
	

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

	public long getTitreProfessionnelId() {
		return titreProfessionnelId;
	}

	public void setTitreProfessionnelId(long titreProfessionnelId) {
		this.titreProfessionnelId = titreProfessionnelId;
	}

	public long getVilleId() {
		return villeId;
	}

	public void setVilleId(long villeId) {
		this.villeId = villeId;
	}

	public List<Long> getEtudiantsId() {
		return etudiantsId;
	}

	public void setEtudiantsId(List<Long> etudiantsId) {
		this.etudiantsId = etudiantsId;
	}

	public PromotionDto() {
		super();
	}

	public String getTitreProfessionnelTitre() {
		return titreProfessionnelTitre;
	}

	public void setTitreProfessionnelTitre(String titreProfessionnelTitre) {
		this.titreProfessionnelTitre = titreProfessionnelTitre;
	}

	public String getVilleNom() {
		return villeNom;
	}

	public void setVilleNom(String villeNom) {
		this.villeNom = villeNom;
	}
		
	
}
