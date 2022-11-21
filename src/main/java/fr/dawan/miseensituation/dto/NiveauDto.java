package fr.dawan.miseensituation.dto;

import java.io.Serializable;

public class NiveauDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	
	//0 :absent, 1 aucune, 2 :notions, 3 :en cours d’acquisition, 4 :acquis, 5 : niv. avancé
	private int valeur;
	
	private String description;
	
	private String codeCouleurHexa;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCodeCouleurHexa() {
		return codeCouleurHexa;
	}

	public void setCodeCouleurHexa(String codeCouleurHexa) {
		this.codeCouleurHexa = codeCouleurHexa;
	}

}
