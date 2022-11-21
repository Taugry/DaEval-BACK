package fr.dawan.miseensituation.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import fr.dawan.miseensituation.dto.BlocCompetencesDto;
import fr.dawan.miseensituation.dto.CompetenceDto;
import fr.dawan.miseensituation.dto.EtudiantDto;
import fr.dawan.miseensituation.dto.EvaluationDto;
import fr.dawan.miseensituation.dto.PromotionDto;
import fr.dawan.miseensituation.dto.TitreProfessionnelDto;
import fr.dawan.miseensituation.dto.evalByBloc;
import fr.dawan.miseensituation.entities.Evaluation;
import fr.dawan.miseensituation.repositories.EvaluationRepository;
import fr.dawan.miseensituation.tools.PdfTools;
import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
@Transactional
public class EvaluationServiceImpl extends GenericServiceImpl<Evaluation, EvaluationDto> implements EvaluationService {

	@Value("${app.storagefolder}")
	private String storageFolder;
	
	@Autowired
	private Configuration freemarkerConfig;
	
	public EvaluationServiceImpl(EvaluationRepository repo) {
		super(repo, Evaluation.class, EvaluationDto.class);
	}

	@Autowired
	private EvaluationRepository EvalRepo;
	
	@Autowired
	private PromotionService PromoService;
	
	@Autowired
	private EtudiantService EtuService;
	
	@Autowired
	private TitreProfessionnelService TitreService;
	
	@Autowired
	private BlocCompetenceService BcService;
	
	@Autowired
	private CompetenceService CompService;
	
	@Autowired
	private EvaluationService EvalService;
	
	@Override
	public double moyenne_etudiant(Long EtudiantID, Long BlocComID) {
		return EvalRepo.RMoyenne_etudiant_BlocCompetance(EtudiantID, BlocComID);
	}

	@Override
	public double moyenne_etudiant_generale(Long EtudiantID) {
		return EvalRepo.RMoyenne_generale_etudiant(EtudiantID);
	}

	
	 @Override public double moyenne_promotion(Long PromotionID, Long BlocComID) {
	 return EvalRepo.RMoyenne_promotion_BlocCompetence(PromotionID, BlocComID); }
	
	 
	 @Override public double moyenne_promotion_generale(Long PromotionID) { return
	 EvalRepo.RMoyenne_generale_promotion(PromotionID); }
	 
	 @Override
		public double moyennePromotionBlocCompetences(Long PromotionID, Long BlocCompID) {
			return EvalRepo.RMoyenne_promotion_BlocCompetence(PromotionID, BlocCompID);
		}
	 
	 @Override
		public double moyenneEtudiantParBloc(Long etudiantID, Long BlocCompID) {
			return EvalRepo.RMoyenne_etudiant_BlocCompetance(etudiantID, BlocCompID);
		}
	 
	 @Override
		public String generatePdf(long etuId, long promoId) throws Exception {
		 
		 	double moyenneglobaleEtudiant = EvalService.moyenne_etudiant_generale(etuId);
		 	
		 	double moyenneglobalePromotion = EvalService.moyenne_promotion_generale(promoId);
			
			EtudiantDto E = EtuService.GenericGetById(etuId);
						
			PromotionDto P = PromoService.GenericGetById(promoId);
					
			TitreProfessionnelDto T = TitreService.GenericGetById(P.getTitreProfessionnelId());
			
			List<BlocCompetencesDto> ListBC = BcService.findAllByTitreProfessionnelId(T.getId());
		
			List<CompetenceDto> ListComp = CompService.GenericGetAll();
						
			freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
						
			Template template = freemarkerConfig.getTemplate("eval.ftl");
			//Une map pour envoyer plusieurs objets au freemarker template
			
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("backendurl", "${backend.url}");
			model.put("t",T);
			model.put("e",E);
			model.put("p",P);	
			model.put("blocs", ListBC);
			model.put("competences", ListComp);
			model.put("moygenetu", moyenneglobaleEtudiant);
			model.put("moygenprom", moyenneglobalePromotion);
			//model.put("evalrepo", EvalRepo);
			
			List<evalByBloc> evalList = new ArrayList<evalByBloc> ();
			for (BlocCompetencesDto bc : ListBC) {
				evalByBloc evalbybloc = new evalByBloc();
				evalbybloc.setBlocCompetences(bc);
				try {
					evalbybloc.setMoyenne(moyenneEtudiantParBloc(E.getId(), bc.getId()));
				} catch (Exception e2) {
					evalbybloc.setMoyenne(0);
				}
				try {
					evalbybloc.setMoyennePromo(moyennePromotionBlocCompetences(P.getId(), bc.getId()));
				} catch (Exception e2) {
					evalbybloc.setMoyennePromo(0);
				}				
				evalList.add(evalbybloc);
			}
			model.put("evalList", evalList);
			
			// on lui demande d'appliquer le template pour l'objet t (titreProfessionnel)
			String htmlContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

			// CONVERSION HTML ================> PDF
			String outputPdf = storageFolder + "/titrepro-" + T.getId() + " & etudiant-" + E.getFirstName()+" "+E.getLastName() + ".pdf";
			PdfTools.generatePdfFromHtml(outputPdf, htmlContent);
			
			return outputPdf;
		}
}
