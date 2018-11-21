package fr.erwan.universite.note.controller;

import org.springframework.ui.Model;

import fr.erwan.universite.note.domain.Note;

public interface INoteController {
	public String notes (Model model);
	
	public String CreerFormulaireNote(Model model);
	
	public String CreerNote(Model model,Note note);
	
	public String notesInferieur(Model model , Float note);
	
	public String notesSuperieur(Model model , Float note);
}
