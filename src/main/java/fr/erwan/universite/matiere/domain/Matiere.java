package fr.erwan.universite.matiere.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import fr.erwan.universite.enseignant.domain.Enseignant;
import fr.erwan.universite.note.domain.Note;

@Entity(name="t_matiere")
public class Matiere {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id ;
	@Column(name="num_matiere")
	private Long matiereNum ;
	@Column(name="nom")
	private String nom ; 
	@Column(name="date_debut")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateDebut ; 
	@Column(name="date_fin")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateFin;
	@Column(name="coef")
	private Integer coef;
	//@Column(name="id_enseignant")
	//private Long enseignantId;
	@ManyToOne
	@JoinColumn(name="id_enseignant")
	private Enseignant enseignant;
	@OneToMany(mappedBy="pkNote.matiere")
	private List<Note>notes;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMatiereNum() {
		return matiereNum;
	}
	public void setMatiereNum(Long matiereNum) {
		this.matiereNum = matiereNum;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Integer getCoef() {
		return coef;
	}
	public void setCoef(Integer coef) {
		this.coef = coef;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
}
