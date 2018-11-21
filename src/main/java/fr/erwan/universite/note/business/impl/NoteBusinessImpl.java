package fr.erwan.universite.note.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.erwan.universite.etudiant.business.IEtudiantBusiness;
import fr.erwan.universite.etudiant.domain.Etudiant;
import fr.erwan.universite.matiere.business.IMatiereBusiness;
import fr.erwan.universite.matiere.domain.Matiere;
import fr.erwan.universite.note.business.INoteBusiness;
import fr.erwan.universite.note.domain.Note;
import fr.erwan.universite.note.repository.INoteRepository;
@Service
public class NoteBusinessImpl implements INoteBusiness{
	@Autowired
	private INoteRepository noteRepository;
	@Autowired
	private IMatiereBusiness matiereBusiness;
	@Autowired
	private IEtudiantBusiness etudiantBusiness;

	@Override
	public List<Note> getAll() {
		return noteRepository.findAll();
	}
	@Override
	public void creer(Note note) {
		noteRepository.save(note);
	}
	@Override
	public List<Matiere> getMatieres() {
		return matiereBusiness.findAll();
	}
	@Override
	public List<Etudiant> getEtudiants() {
		return etudiantBusiness.findAll();
	}
	@Override
	public List<Note> getNoteInf(Float note) {
		return noteRepository.findByNoteLessThan(note);
	}
	@Override
	public List<Note> getNoteSup(Float note) {
		return noteRepository.findByNoteGreaterThan(note);
	}

}
