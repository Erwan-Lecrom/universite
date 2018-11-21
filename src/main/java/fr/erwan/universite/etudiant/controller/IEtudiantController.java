package fr.erwan.universite.etudiant.controller;

import org.springframework.ui.Model;

import fr.erwan.universite.etudiant.domain.Etudiant;

public interface IEtudiantController {
	public String listeEtudiant(Model model);
	
	public String details(Model model , Long id);
	
	public String ajoutFormulaireEtudiant(Model model);
	
	public String ajoutEtudiant(Model model, Etudiant etudiant);
	
	public String supprimerEtudiant(Long id,Model model);
	
	public String chercherEtudiant(Model model , String recherche , String categorie);
}
