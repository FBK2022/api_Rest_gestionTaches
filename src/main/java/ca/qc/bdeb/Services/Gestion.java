package ca.qc.bdeb.Services;

import java.time.LocalDate;
import java.util.List;

import ca.qc.bdeb.Dal.TacheDAO;
import ca.qc.bdeb.Dal.UtilisateurDAO;
import ca.qc.bdeb.Models.Tache;
import ca.qc.bdeb.Models.Utilisateur;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/gestion")
public class Gestion {

	@POST
	@Path("/ajouter/utilisateur/{nomComplet}")
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur ajouterUtilisateur(@PathParam("nomComplet") String nomComplet) {
		UtilisateurDAO manager = new UtilisateurDAO();
		return manager.ajouter(nomComplet);
	}

	@POST
	@Path("/ajouter/tache")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Tache ajouterTache(Tache tache) {
		TacheDAO manager = new TacheDAO();
		return manager.ajouter(tache);
	}

	@DELETE
	@Path("/supprimer/tache/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Tache supprimerTache(@PathParam("id") int id) {
		TacheDAO manager = new TacheDAO();
		return manager.supprimer(id);
	}

	@POST
	@Path("/tache/v2")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public String ajouterTacheV2(Tache tache) {
		TacheDAO manager = new TacheDAO();
		Boolean occupe = false;
		List<Tache> list = manager.trouverList(tache.getUtilisateurId());

		for (int i = 0; i < list.size(); i++) {
			Tache tacheEncours = list.get(i);
			LocalDate dateDebutTacheEncours = tacheEncours.getDateCreation();
			LocalDate dateFinTacheEncours = tacheEncours.getDateCreation().plusDays(tacheEncours.getDuree());
			LocalDate dateDebut = tache.getDateCreation();
			LocalDate dateFin = tache.getDateCreation().plusDays(tache.getDuree());
			if (dateDebut.isBefore(dateFinTacheEncours) && dateDebutTacheEncours.isBefore(dateFin)) {
				occupe = true;
			}
		}
		if (occupe) {
			return " l'utilisateur est occupé avec une autre tache pour cette periode,veuillez notez que la duree maximal d'une"
					+ "tache est de 7 jours";
		} else {
			manager.ajouter(tache);
			return "La tache est ajouter avec succes";
		}
	}

	@POST
	@Path("/tache/v3/{nbRepetition}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String ajouterTacheV3(Tache tache, @PathParam("nbRepetition") int nbRepetition) {
		//TacheDAO manager = new TacheDAO();
		String msg="...";
		for (int i = 0; i < nbRepetition; i++) {
			 msg=ajouterTacheV2(tache);
			tache.setDateCreation(tache.getDateCreation().plusWeeks(1));
		}
		if(msg.equals("La tache est ajouter avec succes"))
		return msg +"--- Tache ajouter pour les " + nbRepetition + " semaine à venir.";
		return msg;
	}

}
