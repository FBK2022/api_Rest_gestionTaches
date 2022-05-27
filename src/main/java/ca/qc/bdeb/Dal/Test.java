package ca.qc.bdeb.Dal;

import java.time.LocalDate;

import ca.qc.bdeb.Models.Tache;

public class Test {
	public static void main(String[] args) {
/*	UtilisateurDAO manager = new UtilisateurDAO();
	var result  = manager.trouver(2);
	//if(result != null)
		System.out.println(result);
		System.out.println(manager.ajouter("ALRX BRUNO"));
	*/
		Tache tache=new Tache("developer methode Calculer",LocalDate.of(2022,05,12) , 3,2);
		TacheDAO managerTache= new TacheDAO();
		System.out.println(managerTache.ajouter(tache));
	//	System.out.println(managerTache.trouver(2));
	//	System.out.println(managerTache.trouverList(2));
		//System.out.println(managerTache.supprimer(5));
		
		
}
}