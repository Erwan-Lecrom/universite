package fr.erwan.universite.matiere.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.erwan.universite.enseignant.business.IEnseignantBusiness;
import fr.erwan.universite.enseignant.domain.Enseignant;
import fr.erwan.universite.matiere.business.IMatiereBusiness;
import fr.erwan.universite.matiere.domain.Matiere;
import fr.erwan.universite.matiere.repository.IMatiereRepository;

@Service
public class MatiereBusinessImpl implements IMatiereBusiness {
	@Autowired
	private IMatiereRepository matiereRepository;
	@Autowired
	private IEnseignantBusiness enseignantBusiness;
	@Override
	public List<Matiere> findAll() {
		return matiereRepository.findAll();
	}

	@Override
	public Matiere findById(Long id) {
		return matiereRepository.getOne(id);
	}

	@Override
	public void creer(Matiere matiere) {
		matiereRepository.save(matiere);
	}

	@Override
	public void supprimer(Long id) {
		matiereRepository.deleteById(id);

	}

	@Override
	public void modifier(Matiere matiere) {
		matiereRepository.save(matiere);
	}

	@Override
	public Enseignant findEnseignantById(Long id){
		return enseignantBusiness.findById(id);
	}

	@Override
	public List<Enseignant> findAllEnseignant() {
		return enseignantBusiness.findAll();
	}

}
