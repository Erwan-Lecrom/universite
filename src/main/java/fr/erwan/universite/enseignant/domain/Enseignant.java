package fr.erwan.universite.enseignant.domain;

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

import fr.erwan.universite.matiere.domain.Matiere;

@Entity(name="t_enseignant")
public class Enseignant {
	@Column(name="id")
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	@NotNull
	@Column(name="num_enseignant")
	private Long enseignantNum;
	@Size(min=2)
	@Column(name="nom")
	private String nom;
	@Size(min=2)
	@Column(name="prenom")
	private String prenom ;
	@Column(name="date_naissance")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateNaissance ;
	@Column(name="grade")
	private String grade ;
	@Column(name="date_embauche")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateEmbauche;
	@Column(name="sexe")
	private char sexe;
	@OneToMany(mappedBy="enseignant")
	private List<Matiere>matieres;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEnseignantNum() {
		return enseignantNum;
	}
	public void setEnseignantNum(Long enseignantNum) {
		this.enseignantNum = enseignantNum;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public char getSexe() {
		return sexe;
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	public List<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}
}
