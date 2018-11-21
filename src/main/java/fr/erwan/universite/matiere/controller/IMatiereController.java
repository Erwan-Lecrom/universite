package fr.erwan.universite.matiere.controller;

import org.springframework.ui.Model;
import fr.erwan.universite.matiere.domain.Matiere;

public interface IMatiereController {
	public String listeMatiere(Model model); 
	
	public String details(Model model , Long id); 
	
	public String ajoutFormulaireMatiere(Model model);
	
	public String ajoutMatiere(Model model ,Matiere matiere,Long id);
	
	public String supprimerMatiere(Model model , Long id);
	
	public String modifierFormulaireMatiere(Model model,Long id);
	
	public String modifierMatiere(Model model,Matiere matiere,Long id);
}
