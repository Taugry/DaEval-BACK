package fr.dawan.miseensituation.dto;

import java.io.Serializable;

public class PositionnementDto implements Serializable {

	private static final long serialVersionUID = -8874821565356962303L;
	
	private long id;
	
	private long etudiantId;
	
    private long interventionId;
    
    private long niveauDebutId;
    
    private long niveauFinId;
    
	private int version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEtudiantId() {
		return etudiantId;
	}

	public void setEtudiantId(long etudiantId) {
		this.etudiantId = etudiantId;
	}

	public long getInterventionId() {
		return interventionId;
	}

	public void setInterventionId(long interventionId) {
		this.interventionId = interventionId;
	}

	public long getNiveauDebutId() {
		return niveauDebutId;
	}

	public void setNiveauDebutId(long niveauDebutId) {
		this.niveauDebutId = niveauDebutId;
	}

	public long getNiveauFinId() {
		return niveauFinId;
	}

	public void setNiveauFinId(long niveauFinId) {
		this.niveauFinId = niveauFinId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
