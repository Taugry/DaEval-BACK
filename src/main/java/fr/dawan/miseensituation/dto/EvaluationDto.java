package fr.dawan.miseensituation.dto;

import java.io.Serializable;

public class EvaluationDto implements Serializable {

	private static final long serialVersionUID = -5242297015530750397L;

	private long id;
	
	private double note;

	private int version;

	private long epreuveId;

	private long etudiantId;
		

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



	public long getEpreuveId() {
		return epreuveId;
	}

	public void setEpreuveId(long epreuveId) {
		this.epreuveId = epreuveId;
	}

	public long getEtudiantId() {
		return etudiantId;
	}

	public void setEtudiantId(long etudiantId) {
		this.etudiantId = etudiantId;
	}

	public EvaluationDto() {
		super();
	}
	
}
