package fr.erwan.universite.etudiant.controller.impl;

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

import fr.erwan.universite.etudiant.business.IEtudiantBusiness;
import fr.erwan.universite.etudiant.business.impl.EtudiantBusinessImpl;
import fr.erwan.universite.etudiant.controller.IEtudiantController;
import fr.erwan.universite.etudiant.domain.Etudiant;

@Controller
public class EtudiantControllerImpl implements IEtudiantController {
	@Autowired
	private IEtudiantBusiness etudiantBusiness=new EtudiantBusinessImpl();
	
	private Logger LOGGER = LoggerFactory.getLogger(EtudiantControllerImpl.class);
	@Override
	@GetMapping("/etudiants")
	public String listeEtudiant(Model model) {
		LOGGER.info("Entree page liste des etudiants");
		List<Etudiant>etudiants=etudiantBusiness.findAll();
		model.addAttribute("etudiants",etudiants);
		return "etudiant/etudiants";
	}

	@Override
	@GetMapping("/etudiant")
	public String details(Model model,@RequestParam Long id) {
		Etudiant etudiant=etudiantBusiness.findById(id);
		model.addAttribute("etudiant",etudiant);
		return "etudiant/etudiant";
	}

	@Override
	@GetMapping("/etudiant/creer")
	public String ajoutFormulaireEtudiant(Model model) {
		Etudiant etudiant=new Etudiant();
		model.addAttribute("etudiant",etudiant);
		return "etudiant/creer";
	}

	@Override
	@PostMapping("/etudiant/creer")
	public String ajoutEtudiant(Model model,@ModelAttribute Etudiant etudiant) {
		etudiantBusiness.creer(etudiant);
		return "redirect:/etudiants";
	}

	@Override
	@RequestMapping("/etudiant/supprimer")
	public String supprimerEtudiant(@RequestParam("id")Long id, Model model) {
		etudiantBusiness.supprimer(id);
		return "redirect:/etudiants";
	}

	@Override
	@RequestMapping("/etudiants/chercher")
	public String chercherEtudiant(Model model,@RequestParam("rechercher") String recherche,@RequestParam("categorie") String categorie) {
		List<Etudiant>etudiants=etudiantBusiness.chercher(recherche, categorie);
		model.addAttribute("etudiants",etudiants);
		return "etudiant/etudiants";
	}

}
