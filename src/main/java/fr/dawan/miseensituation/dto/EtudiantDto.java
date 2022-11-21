package fr.dawan.miseensituation.dto;

import java.util.List;

@SuppressWarnings("serial")
public class EtudiantDto extends UtilisateurDto {

	//private static final long serialVersionUID = 2642703925567125615L;

	private List<Long> promotionsId;

	public List<Long> getPromotionsId() {
		return promotionsId;
	}

	public void setPromotionsId(List<Long> promotionsId) {
		this.promotionsId = promotionsId;
	}

	public EtudiantDto() {
		super();
	}
}
