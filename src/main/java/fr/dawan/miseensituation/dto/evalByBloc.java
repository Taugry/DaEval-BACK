package fr.dawan.miseensituation.dto;

public class evalByBloc {
	
	private BlocCompetencesDto blocCompetencesDto;
	
	private double moyenne;
	
	private double moyennePromo;

	public BlocCompetencesDto getBlocCompetencesDto() {
		return blocCompetencesDto;
	}

	public void setBlocCompetences(BlocCompetencesDto blocCompetencesDto) {
		this.blocCompetencesDto = blocCompetencesDto;
	}

	public double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

	public double getMoyennePromo() {
		return moyennePromo;
	}

	public void setMoyennePromo(double moyennePromo) {
		this.moyennePromo = moyennePromo;
	}
	
	
	
	
}
