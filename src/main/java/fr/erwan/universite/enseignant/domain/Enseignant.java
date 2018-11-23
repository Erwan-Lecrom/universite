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
	private Long enseignantId ;
	@NotNull
	@Column(name="num_enseignant")
	private Long enseignantNum;
	@Size(min=2)
	@Column(name="nom")
	private String enseignantnom;
	@Size(min=2)
	@Column(name="prenom")
	private String Enseignantprenom ;
	@Column(name="date_naissance")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date enseignantdateNaissance ;
	@Column(name="grade")
	private String grade ;
	@Column(name="date_embauche")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateEmbauche;
	@Column(name="sexe")
	private char enseignantsexe;
	@OneToMany(mappedBy="enseignant")
	private List<Matiere>matieres;
	public Long getEnseignantId() {
		return enseignantId;
	}
	public void setEnseignantid(Long enseignantid) {
		enseignantId = enseignantid;
	}
	public Long getEnseignantNum() {
		return enseignantNum;
	}
	public void setEnseignantNum(Long enseignantNum) {
		this.enseignantNum = enseignantNum;
	}
	public String getEnseignantnom() {
		return enseignantnom;
	}
	public void setEnseignantnom(String enseignantnom) {
		enseignantnom = enseignantnom;
	}
	public String getEnseignantprenom() {
		return Enseignantprenom;
	}
	public void setEnseignantprenom(String enseignantprenom) {
		Enseignantprenom = enseignantprenom;
	}
	public Date getEnseignantdateNaissance() {
		return enseignantdateNaissance;
	}
	public void setEnseignantdateNaissance(Date enseignantdateNaissance) {
		enseignantdateNaissance = enseignantdateNaissance;
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
	public char getEnseignantsexe() {
		return enseignantsexe;
	}
	public void setEnseignantsexe(char enseignantsexe) {
		enseignantsexe = enseignantsexe;
	}
	public List<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}
	
}
