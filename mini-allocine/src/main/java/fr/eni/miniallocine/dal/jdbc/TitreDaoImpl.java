package fr.eni.miniallocine.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.eni.miniallocine.bo.Titre;
import fr.eni.miniallocine.dal.TitreDAO;

public class TitreDaoImpl implements TitreDAO {

	private static String INSERT_TITRE = "INSERT INTO titres "
			+ "(nom,synopsis,realisateur,genre,date_sortie,duree,type )"
			+ " VALUES (?,?,?,?,?,?,?)";
	
	@Override
	public Titre selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Titre> selectAll() {
		// TODO Auto-generated method stub
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
