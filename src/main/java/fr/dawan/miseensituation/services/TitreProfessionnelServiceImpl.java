package fr.dawan.miseensituation.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import fr.dawan.miseensituation.tools.PdfTools;

import fr.dawan.miseensituation.dto.BlocCompetencesDto;
import fr.dawan.miseensituation.dto.DtoTools;
import fr.dawan.miseensituation.dto.TitreProfessionnelDto;
import fr.dawan.miseensituation.entities.TitreProfessionnel;
import fr.dawan.miseensituation.repositories.TitreProfessionnelRepository;




@Service
@Transactional
public class TitreProfessionnelServiceImpl extends GenericServiceImpl<TitreProfessionnel,TitreProfessionnelDto> implements TitreProfessionnelService {
	
	@Value("${app.storagefolder}")
	private String storageFolder;

	@Autowired
	private Configuration freemarkerConfig;
	
	@Autowired
	private BlocCompetenceService blocCompetencesService;
	
	
	public TitreProfessionnelServiceImpl(TitreProfessionnelRepository repo) {
		super(repo, TitreProfessionnel.class, TitreProfessionnelDto.class);
	}
	
	@Autowired
	private TitreProfessionnelRepository tPRepo;

	@Override
	public List<TitreProfessionnelDto> getAllPage(int page, int max, String desc) {
		List<TitreProfessionnel> titrespros = tPRepo.findAllByTitreContaining(desc, PageRequest.of(page, max)).get().collect(Collectors.toList());

		List<TitreProfessionnelDto> result = new ArrayList<TitreProfessionnelDto>();
		for (TitreProfessionnel tp : titrespros) {
			result.add(DtoTools.convert(tp, TitreProfessionnelDto.class));
		}
		return result;
	}
	
	@Override
	public String generatePdf(long id) throws Exception {
		
		TitreProfessionnelDto t = GenericGetById(id);
		List<BlocCompetencesDto> blocs = blocCompetencesService.findAllByTitreProfessionnelId(id);
		
		// on définit ici le chemin où il va chercher les fichiers de templates
		freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
				
		// charger le template titrepro.ftl et lui envoyer l'objet t
		Template template = freemarkerConfig.getTemplate("titrepro.ftl");
		//Une map pour envoyer plusieurs objets au freemarker template
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("backendurl", "${backend.url}");
		model.put("t",t);
		model.put("blocs", blocs);
		
		
		// on lui demande d'appliquer le template pour l'objet t (titreProfessionnel)
		String htmlContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

		// CONVERSION HTML ================> PDF
		String outputPdf = storageFolder + "/titrepro-" + t.getId() + ".pdf";
		PdfTools.generatePdfFromHtml(outputPdf, htmlContent);
		
		return outputPdf;
	}

}
