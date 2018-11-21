package fr.erwan.universite.etudiant.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import fr.erwan.universite.note.domain.Note;

@Entity(name="t_etudiant")
public class Etudiant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id ;
	@NotNull
	@Column(name="num_etudiant")
	private Long etudiantNum;
	@Size(min=2)
	@Column(name="nom")
	private String nom ;
	@Size(min=2)
	@Column(name="prenom")
	private String prenom ;
	@Column(name="date_naissance")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateNaissance;
	@Column(name="sexe")
	private char sexe;
	@OneToMany(mappedBy="pkNote.etudiant")
	private List<Note>notes;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEtudiantNum() {
		return etudiantNum;
	}
	public void setEtudiantNum(Long etudiantNum) {
		this.etudiantNum = etudiantNum;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public char getSexe() {
		return sexe;
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}


}
