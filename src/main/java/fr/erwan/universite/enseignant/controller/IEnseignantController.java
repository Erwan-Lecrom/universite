package fr.erwan.universite.enseignant.controller;

import org.springframework.ui.Model;

import fr.erwan.universite.enseignant.domain.Enseignant;

public interface IEnseignantController {
	public String ListeEnseignant(Model model);
	public String details(Model model,Long id);
	public String CreerFormulaireEnseignant(Model model);
	public String CreerEnseignant(Enseignant enseignant,Model model);

	public String ModifierFormulaireEnseignant(Model model,Long id);
	public String ModifierEnseignant(Model model,Enseignant enseignant);
	
	public String supprimerEnseignant(Long id);
}
