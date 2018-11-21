package fr.erwan.universite.note.business;

import java.util.List;

import fr.erwan.universite.etudiant.domain.Etudiant;
import fr.erwan.universite.matiere.domain.Matiere;
import fr.erwan.universite.note.domain.Note;

public interface INoteBusiness {
	public List<Note>getAll();
	public void creer(Note note);
	public List<Matiere>getMatieres();
	public List<Etudiant>getEtudiants();
	public List<Note>getNoteInf(Float note);
	public List<Note>getNoteSup(Float note);
}
