package fr.erwan.universite.note.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.erwan.universite.etudiant.domain.Etudiant;
import fr.erwan.universite.matiere.domain.Matiere;
import fr.erwan.universite.note.business.INoteBusiness;
import fr.erwan.universite.note.controller.INoteController;
import fr.erwan.universite.note.domain.Note;
@Controller
public class NoteControllerImpl implements INoteController{
	@Autowired
	private INoteBusiness noteBusiness;
	@Override
	@RequestMapping("/notes")
	public String notes(Model model) {
		List<Note>notes=noteBusiness.getAll();
		model.addAttribute("notes",notes);
		return "note/notes";
	}
	@Override
	@RequestMapping("/notes/creer")
	public String CreerFormulaireNote(Model model) {
		Note note=new Note();
		List<Etudiant>etudiants=noteBusiness.getEtudiants();
		List<Matiere>matieres=noteBusiness.getMatieres();
		model.addAttribute("etudiants",etudiants);
		model.addAttribute("matieres",matieres);
		model.addAttribute("note",note);
		return "note/creer";
	}
	@Override
	@PostMapping("/notes/creer")
	public String CreerNote(Model model,@RequestParam Note note) {
		noteBusiness.creer(note);
		return "redirect:/notes";
	}
	@Override
	@PostMapping("/notes/inf")
	public String notesInferieur(Model model,@RequestParam("note") Float note) {
		List<Note>notes=noteBusiness.getNoteInf(note);
		model.addAttribute("notes",notes);
		return "note/notes";
	}
	@Override
	@PostMapping("/notes/sup")
	public String notesSuperieur(Model model, Float note) {
		List<Note>notes=noteBusiness.getNoteSup(note);
		model.addAttribute("notes",notes);
		return "note/notes";
	}

}
