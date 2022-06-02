package ca.qc.bdeb.Dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import ca.qc.bdeb.Models.Tache;

public class TacheDAO implements ITacheDAO {

	final static String DB_URL = "jdbc:mysql://mysql-aliantoine.alwaysdata.net:3306/aliantoine_tpa15?useSSL=false";
	final static String USERNAME = "??????";
	final static String PASSWORD = "??????";

	Connection connection;
	
	@SuppressWarnings("deprecation")
	public TacheDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Tache ajouter(Tache tache) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String request = "INSERT INTO TbL_Tache(Description, DateCreation, Duree,UtilisateurID) VALUES (";
		request += "'" + tache.getDescription() + "',";
		request += "'" + tache.getDateCreation().format(df) + "',";
		request += "'" + tache.getDuree() + "',";
		request += "'" + tache.getUtilisateurId() + "')";
		try {
			Statement statement = connection.createStatement();
			 statement.executeUpdate(request);
			 ResultSet result=  statement.executeQuery("SELECT * FROM TbL_Tache ORDER BY TacheID DESC LIMIT 1");
			  if (result.next()) {
				  Tache tacheInsert = new Tache();
					tacheInsert.setId(result.getInt("TacheID"));
					tacheInsert.setDescription(result.getString("Description"));
					// convert Date to LocalDate
					tacheInsert.setDateCreation(result.getDate("DateCreation").toLocalDate());
					tacheInsert.setDuree(result.getInt("Duree"));
					tacheInsert.setUtilisateurId(result.getInt("UtilisateurID"));
					return tacheInsert;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Tache trouver(int id) {
		String request = "SELECT * FROM  TbL_Tache WHERE TacheID = " + id;
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(request);
			if (result.next()) {
				Tache tache = new Tache();
				tache.setId(result.getInt("TacheID"));
				tache.setDescription(result.getString("Description"));
				// convert Date to LocalDate
				tache.setDateCreation(result.getDate("DateCreation").toLocalDate());
				tache.setDuree(result.getInt("Duree"));
				tache.setUtilisateurId(result.getInt("UtilisateurID"));
				return tache;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Tache> trouverList(int idUtilisateur) {
		String request = "SELECT * FROM  TbL_Tache WHERE UtilisateurID="+idUtilisateur;
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(request);
			List<Tache> taches = new ArrayList<Tache>();
			while (result.next()) {
				Tache tache = new Tache();
				tache.setId(result.getInt("TacheID"));
				tache.setDescription(result.getString("Description"));
				// convert Date to LocalDate
				tache.setDateCreation(result.getDate("DateCreation").toLocalDate());
				tache.setDuree(result.getInt("Duree"));
				tache.setUtilisateurId(result.getInt("UtilisateurID"));
				// add to list
				taches.add(tache);
			}
			return taches;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Tache supprimer(int id) {
		Tache tache=trouver( id);
		String request = "DELETE FROM TbL_Tache WHERE TacheID = ";
	       request += id;
	try {
		Statement statement = connection.createStatement();
	    statement.executeUpdate(request);
		return tache;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
	

}
