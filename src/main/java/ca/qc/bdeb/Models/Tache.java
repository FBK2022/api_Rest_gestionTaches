package ca.qc.bdeb.Models;

import java.time.LocalDate;

public class Tache {
	private int id;
	private String description;
	private LocalDate dateCreation;
	private int duree;
	private int utilisateurId;
	
	public Tache() {
		super();
	}

	public Tache(String description, LocalDate dateCreation, int duree, int utilisateurId) {
		super();
		this.description = description;
		this.dateCreation = dateCreation;
		this.duree = duree;
		this.utilisateurId = utilisateurId;
	}

	public Tache(int id, String description, LocalDate dateCreation, int duree, int utilisateurId) {
		super();
		this.id = id;
		this.description = description;
		this.dateCreation = dateCreation;
		this.duree = duree;
		this.utilisateurId = utilisateurId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	@Override
	public String toString() {
		return "Tache [id=" + id + ", description=" + description + ", dateCreation=" + dateCreation + ", duree="
				+ duree + ", utilisateurId=" + utilisateurId + "\n"+"]";
	}


}
