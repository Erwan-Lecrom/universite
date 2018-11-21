package fr.erwan.universite.matiere.business;

import java.util.List;

import fr.erwan.universite.enseignant.domain.Enseignant;
import fr.erwan.universite.matiere.domain.Matiere;

public interface IMatiereBusiness {
	public List<Matiere>findAll();
	
	public Matiere findById(Long id);
	
	public void creer(Matiere matiere);
	
	public void supprimer(Long id);
	
	public void modifier(Matiere matiere);
	
	public Enseignant findEnseignantById(Long id);
	
	public List<Enseignant>findAllEnseignant();
}
