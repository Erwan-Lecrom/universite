package fr.erwan.universite.etudiant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.erwan.universite.etudiant.domain.Etudiant;
import fr.erwan.universite.note.domain.Note;
@Repository
public interface IEtudiantrepository extends JpaRepository<Etudiant, Long> {
	public List<Etudiant>findByNomIs(String nom);
	public List<Etudiant>findByPrenomIs(String prenom);
}
