package fr.erwan.universite.note.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.erwan.universite.etudiant.domain.Etudiant;
import fr.erwan.universite.matiere.domain.Matiere;

@Embeddable
public class PKNote implements Serializable{

	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="id_etudiant",insertable=false, updatable=false)
	private Etudiant etudiant;
	@ManyToOne
	@JoinColumn(name="id_matiere",insertable=false, updatable=false)
	private Matiere matiere;

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
}
