package fr.erwan.universite.enseignant.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.erwan.universite.enseignant.business.IEnseignantBusiness;
import fr.erwan.universite.enseignant.domain.Enseignant;
import fr.erwan.universite.enseignant.repository.IEnseignantRepository;


@Service
public class EnseignantBusinessImpl implements IEnseignantBusiness {
	@Autowired
	private IEnseignantRepository enseignantRepository;
	@Override
	public List<Enseignant> findAll() {	
		return enseignantRepository.findAll();
	}

	@Override
	public Enseignant findById(Long id){
		return  enseignantRepository.getOne(id);
	}

	@Override
	public void creer(Enseignant enseignant) {
		enseignantRepository.save(enseignant);	
	}

	@Override
	public void supprimer(Long id) {
		enseignantRepository.deleteById(id);

	}

	@Override
	public void modifier(Enseignant enseignant) {
		enseignantRepository.modifier(enseignant.getGrade(),enseignant.getDateEmbauche(),enseignant.getEnseignantId());

	}

}
