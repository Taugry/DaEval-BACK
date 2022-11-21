package fr.dawan.miseensituation.services;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import fr.dawan.miseensituation.dto.DtoTools;
import fr.dawan.miseensituation.dto.PositionnementDto;
import fr.dawan.miseensituation.entities.Intervention;
import fr.dawan.miseensituation.entities.Positionnement;
import fr.dawan.miseensituation.entities.Promotion;
import fr.dawan.miseensituation.repositories.PositionnementRepository;
import fr.dawan.miseensituation.repositories.PromotionRepository;
import fr.dawan.miseensituation.tools.PdfTools;
import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
@Transactional
public class PositionnementServiceImpl extends GenericServiceImpl<Positionnement, PositionnementDto> implements PositionnementService{

	public PositionnementServiceImpl(PositionnementRepository repo) {
		super(repo, Positionnement.class, PositionnementDto.class);
	}

	@Autowired
	private PositionnementRepository repository;

	@Autowired
	private PromotionRepository promotionRepository;

	@Autowired
	private Configuration freemarkerConfig;

	@Value("${app.storagefolder}")
	private String storageFolder;

	@Value(value = "${backend.url}")
	private String backEndUrl;
	
	public String getBackEndUrl() {
		return backEndUrl;
	}

	public void setBackEndUrl(String backEndUrl) {
		this.backEndUrl = backEndUrl;
	}
	
	public String getStorageFolder() {
		return storageFolder;
	}

	public void setStorageFolder(String storageFolder) {
		this.storageFolder = storageFolder;
	}

	

	@Override
	public List<PositionnementDto> getAllByEtudiantAndPromo(long etudiantId, long promotionId) throws Exception {
		List<Positionnement> positionnements = repository.getAllByEtudiantAndPromo(etudiantId, promotionId);

		// on transforme le résultat en liste de DTO
		List<PositionnementDto> result = new ArrayList<PositionnementDto>();
		for (Positionnement u : positionnements) {
			result.add(DtoTools.convert(u, PositionnementDto.class));
		}
		return result;
	}

	@Override
	public PositionnementDto getByEtudiantAndIntervention(long etudiantId, long interventionId) throws Exception {
		return DtoTools.convert(repository.getByEtudiantAndIntervention(etudiantId, interventionId),
				PositionnementDto.class);
	}

	@Override
	public String generatePdf(long promotionId) throws Exception {
		Optional<Promotion> promotionOpt = promotionRepository.findById(promotionId);
		Promotion promotion = null;
		if (promotionOpt.isPresent()) {
			promotion = promotionOpt.get();

			freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
			Template template = freemarkerConfig.getTemplate("grille.ftl");
			
			
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("promotion",promotion);
			model.put("backEndUrl",backEndUrl);
			
			List<Positionnement> positionnementsByPromo = repository.findAllByPromotionId(promotionId);
			Map<Intervention, List<Positionnement>> posiByPromoMap = positionnementsByPromo.stream()
					.collect(Collectors.groupingBy(Positionnement::getIntervention));
			
			model.put("posiByPromoEntries", posiByPromoMap.entrySet());
			
			
			for (Intervention interv : posiByPromoMap.keySet()) {
				System.out.println("formation : " + interv.getFormation().getTitre());
				for (Positionnement pos : posiByPromoMap.get(interv)) {
					System.out.println(pos.getEtudiant().getFirstName() + " - NivDeb : " + pos.getNiveauDebut().getValeur()
							+ " - NivFin : " + pos.getNiveauFin().getValeur());
				}
				System.out.println("---------");
			}

			// on lui demande d'appliquer le template pour l'objet t (titreProfessionnel)
			String htmlContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

			// CONVERSION HTML ================> PDF
			String outputPdf = storageFolder + "/grille-promo-" + promotion.getId() + ".pdf";
			PdfTools.generatePdfFromHtml(outputPdf, htmlContent);

			return outputPdf;
		}

		return null;

	}

}
