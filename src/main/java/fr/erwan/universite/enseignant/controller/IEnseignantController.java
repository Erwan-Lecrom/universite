package fr.erwan.universite.enseignant.controller;

import org.springframework.ui.Model;

import fr.erwan.universite.enseignant.domain.Enseignant;

public interface IEnseignantController {
	public String listeEnseignant(Model model);
	public String details(Model model,Long id);
	public String creerFormulaireEnseignant(Model model);
	public String creerEnseignant(Enseignant enseignant,Model model);

	public String modifierFormulaireEnseignant(Model model,Long id);
	public String modifierEnseignant(Model model,Enseignant enseignant);
	
	public String supprimerEnseignant(Long id);
}
