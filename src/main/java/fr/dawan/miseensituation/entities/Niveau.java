package fr.dawan.miseensituation.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Niveau implements Serializable {

	private static final long serialVersionUID = -6890714157286475547L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public Niveau(long id, int valeur, String description, String codeCouleurHexa) {
		super();
		this.id = id;
		this.valeur = valeur;
		this.description = description;
		this.codeCouleurHexa = codeCouleurHexa;
	}

	public Niveau() {
		super();
	}	
}
