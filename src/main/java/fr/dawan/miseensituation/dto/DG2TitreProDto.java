package fr.dawan.miseensituation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DG2TitreProDto {
	
	@JsonProperty(value = "full_alias")
	private String full_alias;
	private float score;
	private DG2TrainingDto Training;
	
	public String getFull_alias() {
		return full_alias;
	}
	public void setFull_alias(String full_alias) {
		this.full_alias = full_alias;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public DG2TrainingDto getTraining() {
		return Training;
	}
	public void setTraining(DG2TrainingDto training) {
		Training = training;
	}
	
	

}
