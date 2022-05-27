package ca.qc.bdeb.Models;

public class Utilisateur {
	private int utilisateurId;
	private String nomComplet;
	
	
	
	public Utilisateur() {
		super();
	}
	
	
	public Utilisateur(String nomComplet) {
		super();
		this.nomComplet = nomComplet;
	}


	public Utilisateur(int utilisateurId, String nomComplet) {
		super();
		this.utilisateurId = utilisateurId;
		this.nomComplet = nomComplet;
	}



	public int getUtilisateurId() {
		return utilisateurId;
	}



	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}



	public String getNomComplet() {
		return nomComplet;
	}



	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}


	@Override
	public String toString() {
		return "Utilisateur [utilisateurId=" + utilisateurId + ", nomComplet=" + nomComplet + "]";
	}
	
	
	
	
}
