package fr.erwan.universite.matiere.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.erwan.universite.enseignant.domain.Enseignant;
import fr.erwan.universite.matiere.business.IMatiereBusiness;
import fr.erwan.universite.matiere.controller.IMatiereController;
import fr.erwan.universite.matiere.domain.Matiere;

@Controller
public class MatiereControllerImpl implements IMatiereController {
	@Autowired
	private IMatiereBusiness matiereBusiness;
	private Logger LOGGER=LoggerFactory.getLogger(MatiereControllerImpl.class);
	private static String REDIRECT_MATIERES="redirect:/matieres";
	private static String ATTR_MATIERE="matiere";
	@Override
	@GetMapping("/matieres")
	public String listeMatiere(Model model) {
		LOGGER.info("Controlleur listeMatiere");
		List<Matiere>matieres=matiereBusiness.findAll();
		LOGGER.info("creation attribut contenant la liste des matieres");
		model.addAttribute("matieres",matieres);
		LOGGER.info("Chargement de la page liste matiere");
		return "matiere/matieres";
	}

	@Override
	@GetMapping("/matiere")
	public String details(Model model,@RequestParam("id") Long id){
		Matiere matiere=matiereBusiness.findById(id);
		model.addAttribute(ATTR_MATIERE,matiere);
		return "matiere/matiere";
	}

	@Override
	@GetMapping("/matiere/creer")
	public String ajoutFormulaireMatiere(Model model) {
		List<Enseignant>enseignants=matiereBusiness.findAllEnseignant();
		Matiere matiere=new Matiere();
		model.addAttribute("titreForm","Creation matiere");
		model.addAttribute("submit","creer");
		model.addAttribute(ATTR_MATIERE,matiere);
		model.addAttribute("enseignants",enseignants);
		return "matiere/form";
	}

	@Override
	@PostMapping("/matiere/creer")
	public String ajoutMatiere(Model model,@ModelAttribute  Matiere matiere,@RequestParam("enseignantId") Long id) {
		Enseignant enseignant=matiereBusiness.findEnseignantById(id);
		matiere.setEnseignant(enseignant);
		matiereBusiness.creer(matiere);
		return REDIRECT_MATIERES;
	}

	@Override
	@RequestMapping("/matiere/supprimer")
	public String supprimerMatiere(Model model,@RequestParam("id") Long id) {
		matiereBusiness.supprimer(id);
		model.addAttribute("msgSuppr","La matiere a bien ete supprimes");
		return REDIRECT_MATIERES;
	}

	@Override
	@RequestMapping("/matiere/modifier")
	public String modifierFormulaireMatiere(Model model,@RequestParam("id") Long id) {
		model.addAttribute("titreForm","Modification matiere");
		model.addAttribute("submit","modifier");
		Matiere matiere=matiereBusiness.findById(id);
		model.addAttribute(ATTR_MATIERE,matiere);
		List<Enseignant>enseignants=matiereBusiness.findAllEnseignant();
		model.addAttribute("enseignants",enseignants);
		return "matiere/form";
	}

	@Override
	@PostMapping("/matiere/modifier")
	public String modifierMatiere(Model model,@ModelAttribute Matiere matiere,@RequestParam("enseignantId")Long id) {
		Enseignant enseignant =matiereBusiness.findEnseignantById(id);
		matiere.setEnseignant(enseignant);
		matiereBusiness.modifier(matiere);
		return "redirect:/matieres";
		
	}
}
