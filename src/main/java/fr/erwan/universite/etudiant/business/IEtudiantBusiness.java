package fr.erwan.universite.etudiant.business;

import java.util.List;

import fr.erwan.universite.etudiant.domain.Etudiant;

public interface IEtudiantBusiness {
	public List<Etudiant> findAll();
	
	public Etudiant findById(Long id);
	
	public void creer(Etudiant etudiant);
	
	public void supprimer(Long id);
	
	public List<Etudiant>chercher(String chercher ,String categorie);
}
