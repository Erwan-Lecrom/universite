package fr.erwan.universite.enseignant.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.erwan.universite.enseignant.business.IEnseignantBusiness;
import fr.erwan.universite.enseignant.controller.IEnseignantController;
import fr.erwan.universite.enseignant.domain.Enseignant;

@Controller
public class EnseignantControllerImpl implements IEnseignantController{
	@Autowired
	private IEnseignantBusiness enseignantBusiness;
	private Logger LOGGER = LoggerFactory.getLogger(EnseignantControllerImpl.class);
	private static String REDIRECT_ENSEIGNANTS="redirect:/enseignants";
	private static String ATTR_ENSEIGNANT="enseignant";
	@Override
	@RequestMapping("/enseignants")
	public String listeEnseignant(Model model) {
		LOGGER.info("Entree dans le controlleur qui gere la page des liste d'enseignants");
		LOGGER.info("Recuperation de la liste des utilisateur dans la BDD");
		List<Enseignant>enseignants=enseignantBusiness.findAll();
		LOGGER.info("Creation de l'attribut contenant la liste des enseignants");
		model.addAttribute("enseignants",enseignants);
		LOGGER.info("Chargement de la page de la liste des enseignants");
		return "enseignant/enseignants";
	}
	@Override
	@RequestMapping("/enseignant")
	public String details(Model model , @RequestParam("id") Long id) {
		LOGGER.info("Entree dans le controlleur qui gere la page details de l'enseignant");
		Enseignant enseignant;
		try {
			LOGGER.info("Tentative de récupération de l'enseignant en fonction de l'id");
			enseignant = enseignantBusiness.findById(id);
			LOGGER.info("Enseignant recuperé et creation de l'attribut contenant l'enseignant");
			model.addAttribute(ATTR_ENSEIGNANT,enseignant);
			LOGGER.info("chargement de la page");
			return "enseignant/enseignant";
		} catch (Exception e) {
			model.addAttribute("erreur","l'utilisateur n'existe pas dans la BDD");
			return REDIRECT_ENSEIGNANTS;
		}


	}
	@Override
	@RequestMapping("/enseignant/creer")
	public String creerFormulaireEnseignant(Model model) {
		LOGGER.info("Entree dans le controlleur qui gere la formulaire de creation d'un enseignant");
		model.addAttribute("titreForm","Creation enseignant");
		LOGGER.info("Creation d'un objet enseignant vide");
		Enseignant e=new Enseignant();
		model.addAttribute(ATTR_ENSEIGNANT,e);
		LOGGER.info("On charge le formulaire");
		return "enseignant/form";
	}

	@Override
	@PostMapping("/enseignant/creer")
	public String creerEnseignant(@ModelAttribute Enseignant enseignant,Model model) {
		LOGGER.info("on verifie la validite des données");
		enseignantBusiness.creer(enseignant);
		return REDIRECT_ENSEIGNANTS;
	}

	@Override
	@RequestMapping("/enseignant/modifier")
	public String modifierFormulaireEnseignant(Model model,@RequestParam Long id) {
		Enseignant enseignant = enseignantBusiness.findById(id);
		model.addAttribute("titreForm","Modification enseignant");
		model.addAttribute(ATTR_ENSEIGNANT,enseignant);
		return "enseignant/form";
	}


	@Override
	@PostMapping("/enseignants/modifier")
	public String modifierEnseignant(Model model,@ModelAttribute Enseignant enseignant) {

		return REDIRECT_ENSEIGNANTS;
	}
	@Override
	@RequestMapping("/enseignant/supprimer")
	public String supprimerEnseignant(@RequestParam("id") Long id) {
		enseignantBusiness.supprimer(id);
		return REDIRECT_ENSEIGNANTS;
	}
}
