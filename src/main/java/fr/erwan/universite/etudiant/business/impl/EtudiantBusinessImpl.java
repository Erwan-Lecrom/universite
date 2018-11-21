package fr.erwan.universite.etudiant.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.erwan.universite.etudiant.business.IEtudiantBusiness;
import fr.erwan.universite.etudiant.domain.Etudiant;
import fr.erwan.universite.etudiant.repository.IEtudiantrepository;

@Service
public class EtudiantBusinessImpl implements IEtudiantBusiness {
	@Autowired
	private IEtudiantrepository etudiantRepository;
	@Override
	public List<Etudiant> findAll() {
		return etudiantRepository.findAll();
	}

	@Override
	public Etudiant findById(Long id) {
		return etudiantRepository.getOne(id);
	}

	@Override
	public void creer(Etudiant etudiant) {
		etudiantRepository.save(etudiant);	
	}

	@Override
	public void supprimer(Long id) {
		etudiantRepository.deleteById(id);
	}

	@Override
	public List<Etudiant> chercher(String chercher, String categorie) {
		if (categorie.equals("nom")) {
			return etudiantRepository.findByNomIs(chercher);
		}else if (categorie.equals("prenom")) {
			return etudiantRepository.findByPrenomIs(chercher);
		}
		return null;
	}



}
