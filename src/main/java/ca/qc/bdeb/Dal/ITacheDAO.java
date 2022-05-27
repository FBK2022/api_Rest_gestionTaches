package ca.qc.bdeb.Dal;

import java.util.List;

import ca.qc.bdeb.Models.Tache;

public interface ITacheDAO {
	public Tache ajouter(Tache tache);
	public Tache trouver(int id);
	public List<Tache> trouverList(int idUtilisateur);
	public Tache supprimer(int id);

}
