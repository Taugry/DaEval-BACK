package fr.dawan.miseensituation.dto;

public class DG2TrainingDto {
	
	private String title;
	private String duration;
	private String description = null;
	private String slug;
	private String alias;
	private String fullAlias;
	private float standardPrice;
	private float customPrice;
	private float customPriceExtra;
	private float remotelyPrice;
	private String objectives;
	private String prerequisites;

	// Getter Methods

	public String getTitle() {
		return title;
	}

	public String getDuration() {
		return duration;
	}

	public String getDescription() {
		return description;
	}

	public String getSlug() {
		return slug;
	}

	public String getAlias() {
		return alias;
	}

	public String getFullAlias() {
		return fullAlias;
	}

	public float getStandardPrice() {
		return standardPrice;
	}

	public float getCustomPrice() {
		return customPrice;
	}

	public float getCustomPriceExtra() {
		return customPriceExtra;
	}

	public float getRemotelyPrice() {
		return remotelyPrice;
	}

	public String getObjectives() {
		return objectives;
	}

	public String getPrerequisites() {
		return prerequisites;
	}

	// Setter Methods

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setFullAlias(String fullAlias) {
		this.fullAlias = fullAlias;
	}

	public void setStandardPrice(float standardPrice) {
		this.standardPrice = standardPrice;
	}

	public void setCustomPrice(float customPrice) {
		this.customPrice = customPrice;
	}

	public void setCustomPriceExtra(float customPriceExtra) {
		this.customPriceExtra = customPriceExtra;
	}

	public void setRemotelyPrice(float remotelyPrice) {
		this.remotelyPrice = remotelyPrice;
	}

	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}

	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}
}
