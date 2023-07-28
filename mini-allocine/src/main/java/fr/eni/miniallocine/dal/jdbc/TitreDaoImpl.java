package fr.eni.miniallocine.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.miniallocine.bo.Titre;
import fr.eni.miniallocine.dal.TitreDAO;

public class TitreDaoImpl implements TitreDAO {

	private static String INSERT_TITRE = "INSERT INTO titres "
			+ "(nom,synopsis,realisateur,genre,date_sortie,duree,type )"
			+ " VALUES (?,?,?,?,?,?,?)";
	
	private static String SELECT_ALL_TITRE = "SELECT * FROM titres";
	
	@Override
	public Titre selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Titre> selectAll() {
		// 
		try(Connection connection = ConnectionProvider.getConnection()){
			Statement stmt = connection.createStatement();
			ResultSet rs =stmt.executeQuery(SELECT_ALL_TITRE);
			List<Titre> titres = new ArrayList<Titre>();
			while(rs.next()) {
				Titre titre = new Titre(rs.getInt("id"), rs.getString("nom"),
						rs.getString("synopsis"), rs.getString("realisateur"),
						rs.getString("genre"), rs.getDate("date_sortie").toLocalDate(), 
						rs.getInt("duree"), rs.getBoolean("type"));
				titres.add(titre);
			}
			return titres;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void update(Titre titre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Titre titre) {
		try(Connection connection = ConnectionProvider.getConnection()){
			// preparer la requete SQL (Insert)
			PreparedStatement pStmt = connection.prepareStatement(INSERT_TITRE);
			// Ajouter les données
			pStmt.setString(1, titre.getNom());
			pStmt.setString(2, titre.getSynopsis());
			pStmt.setString(3, titre.getRealisateur());
			pStmt.setString(4, titre.getGenre());
			pStmt.setDate(5, Date.valueOf(titre.getDateSortie())  );
			pStmt.setInt(6, titre.getDuree());
			pStmt.setBoolean(7, titre.isType());
			// executer 
			pStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}				
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
