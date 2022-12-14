package fr.dawan.miseensituation.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class InterventionDto implements Serializable {

	private static final long serialVersionUID = -8941619721274059268L;
	
	private long id;
	
	private LocalDate dateDebut;
	
	private LocalDate dateFin;
	
	int version;
	 
    private long formationId; 
    
    private long promotionId;
    
    private long formateurId;

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

	public long getFormationId() {
		return formationId;
	}

	public void setFormationId(long formationId) {
		this.formationId = formationId;
	}

	public long getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(long promotionId) {
		this.promotionId = promotionId;
	}

	public long getFormateurId() {
		return formateurId;
	}

	public void setFormateurId(long formateurId) {
		this.formateurId = formateurId;
	}

}
