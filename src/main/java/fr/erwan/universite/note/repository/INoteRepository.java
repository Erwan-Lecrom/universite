package fr.erwan.universite.note.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.erwan.universite.note.domain.Note;
import fr.erwan.universite.note.domain.PKNote;
@Repository
public interface INoteRepository extends JpaRepository<Note,PKNote> {
	public List<Note> findByNoteLessThan(Float note);
	public List<Note> findByNoteGreaterThan(Float note);
	public List<Note> findBypkNoteIs(PKNote pkNote);
 }
