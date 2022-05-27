package ca.qc.bdeb.Services;

import java.util.List;

import ca.qc.bdeb.Dal.TacheDAO;
import ca.qc.bdeb.Dal.UtilisateurDAO;
import ca.qc.bdeb.Models.Tache;
import ca.qc.bdeb.Models.Utilisateur;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/voir")
public class Consultation {
	
	@GET
	@Path("/utilisateur/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur voirUtilisateur(@PathParam("id") int id) {
		UtilisateurDAO manager = new UtilisateurDAO();
		return manager.trouver(id);		
	}
	
	@GET
	@Path("/tache/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Tache voirTache(@PathParam("id") int id) {
		TacheDAO manager = new TacheDAO();
		return manager.trouver(id);
	}
	
	@GET
	@Path("/tache/utilisateur/{idUtilisateur}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tache> voirTacheListe(@PathParam("idUtilisateur") int idUtilisateur) {
		TacheDAO manager = new TacheDAO();
		return manager.trouverList(idUtilisateur);
	}

}
