package fr.dawan.miseensituation.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Promotion implements Serializable {

	private static final long serialVersionUID = -5702753053255848642L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	LocalDate dateDebut;

	LocalDate dateFin;

	@Version
	private int version;

	@ManyToOne(optional = false)
	private TitreProfessionnel titreProfessionnel;

	@ManyToOne(optional = false)
	private Ville ville;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Etudiant> etudiants;

	public List<Long> getEtudiantsId() {
		List<Long> etudiantsId = new ArrayList<Long>();
		if (etudiants != null) {
			for (Etudiant etu : etudiants) {
				if (etu != null)
					etudiantsId.add(etu.getId());
			}
		}
		return etudiantsId;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

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

	public TitreProfessionnel getTitreProfessionnel() {
		return titreProfessionnel;
	}

	public void setTitreProfessionnel(TitreProfessionnel titreProfessionnel) {
		this.titreProfessionnel = titreProfessionnel;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Promotion(long id, LocalDate dateDebut, LocalDate dateFin, int version,
			TitreProfessionnel titreProfessionnel, Ville ville, List<Etudiant> etudiants) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.version = version;
		this.titreProfessionnel = titreProfessionnel;
		this.ville = ville;
		this.etudiants = etudiants;
	}

	public Promotion() {
		super();
	}
}
