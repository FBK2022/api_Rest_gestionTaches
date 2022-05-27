package ca.qc.bdeb.Dal;

import ca.qc.bdeb.Models.Utilisateur;

public interface IUtilisateurDAO {
	
		public  Utilisateur ajouter(String nomComplet);
		public  Utilisateur trouver(int id);

	}


