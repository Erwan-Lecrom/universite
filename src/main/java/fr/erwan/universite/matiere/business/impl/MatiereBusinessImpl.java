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
		List<Matiere>matieres=matiereRepository.findAll();
		return matieres;
	}

	@Override
	public Matiere findById(Long id) {
		Matiere matiere=matiereRepository.getOne(id);
		return matiere;
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
		try {
			return enseignantBusiness.findById(id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Enseignant> findAllEnseignant() {
		return enseignantBusiness.findAll();
	}

}
