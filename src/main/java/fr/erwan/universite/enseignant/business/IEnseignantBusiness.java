package fr.erwan.universite.enseignant.business;

import java.util.List;

import fr.erwan.universite.enseignant.domain.Enseignant;

public interface IEnseignantBusiness {
	public List<Enseignant> findAll();
	
	public Enseignant findById(Long id);
	
	public void creer(Enseignant enseignant);
	
	public void modifier(Enseignant enseignant);
	public void supprimer(Long id);
}
