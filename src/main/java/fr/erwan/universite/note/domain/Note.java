package fr.erwan.universite.note.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
@Entity(name="t_note")
public class Note {
	@EmbeddedId
	private PKNote pkNote;
	private Float note;
	public Float getNote() {
		return note;
	}

	public void setNote(Float note) {
		this.note = note;
	}

	public PKNote getPkNote() {
		return pkNote;
	}

	public void setPkNote(PKNote pkNote) {
		this.pkNote = pkNote;
	}

}
