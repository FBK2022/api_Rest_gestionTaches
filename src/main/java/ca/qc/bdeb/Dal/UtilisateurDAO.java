package ca.qc.bdeb.Dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;

import ca.qc.bdeb.Models.Utilisateur;

public class UtilisateurDAO implements IUtilisateurDAO {
	/* UTILISATION DE JDBC */
	final static String DB_URL = "jdbc:mysql://mysql-aliantoine.alwaysdata.net:3306/aliantoine_tpa15?useSSL=false";
	final static String USERNAME = "???";
	final static String PASSWORD = "?????";

	Connection connection;

	@SuppressWarnings("deprecation")
	public UtilisateurDAO() {
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
	public Utilisateur  ajouter(String nomComplet) {
		String request = "INSERT INTO TbL_Utilisateur(NomComplet) VALUES (";
		request += "'" + nomComplet +  "')";	
		Utilisateur utilisateur = new Utilisateur();
		try {
			Statement statement = connection.createStatement();
			 statement.executeUpdate(request);
			 ResultSet result=  statement.executeQuery("SELECT * FROM TbL_Utilisateur ORDER BY UtilisateurID DESC LIMIT 1");
			  if (result.next()) {
					utilisateur.setUtilisateurId(result.getInt("UtilisateurID"));
					utilisateur.setNomComplet(result.getString("NomComplet"));
					return utilisateur;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Utilisateur trouver(int id) {
		String request = "SELECT * FROM TbL_Utilisateur WHERE UtilisateurID = " + id;
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(request);
			if (result.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setUtilisateurId(result.getInt("UtilisateurID"));
				utilisateur.setNomComplet(result.getString("NomComplet"));
				return utilisateur;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
