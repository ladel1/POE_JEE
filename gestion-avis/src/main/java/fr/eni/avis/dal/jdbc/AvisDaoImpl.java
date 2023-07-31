package fr.eni.avis.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.avis.bo.Avis;
import fr.eni.avis.dal.AvisDao;

public class AvisDaoImpl implements AvisDao {
	
	private static final String SQL_SELECT_ALL = "SELECT * FROM avis";
	private static final String SQL_SELECT_ONE = "SELECT * FROM avis WHERE id= ?";
	private static final String SQL_INSERT = "INSERT INTO  avis (username,rating,product_name,comment) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE avis SET username = ?,rating = ?,product_name = ?,comment = ?   WHERE id = ?";
	

	@Override
	public List<Avis> findAll() {
		try(Connection connection = ConnectionProvider.getConnection() ){
			Statement stmt = connection.createStatement();
			ResultSet rs =stmt.executeQuery(SQL_SELECT_ALL);
			List<Avis> avis = new ArrayList<Avis>();
			while(rs.next()) {
				avis.add(
						new Avis(rs.getInt("id"), 
								rs.getString("username"), 
								rs.getInt("rating"), 
								rs.getString("product_name"), 
								rs.getDate("date_created").toLocalDate(), 
								rs.getString("comment"))
						);
			}
			return avis;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Avis findOne(Integer id) {
		try(Connection connection = ConnectionProvider.getConnection() ){
			PreparedStatement pstmt = connection.prepareStatement(SQL_SELECT_ONE);
			pstmt.setInt(1, id);
			ResultSet rs =pstmt.executeQuery();			
			if(rs.next()) {
				return new Avis(rs.getInt("id"), 
								rs.getString("username"), 
								rs.getInt("rating"), 
								rs.getString("product_name"), 
								rs.getDate("date_created").toLocalDate(), 
								rs.getString("comment"));
			}		
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(Avis avis) {
		try(    
				Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT)	
				){			
			pstmt.setString(1, avis.getUsername());
			pstmt.setInt(2, avis.getRating());
			pstmt.setString(3, avis.getProductName());
			pstmt.setString(4, avis.getComment());
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void update(Avis avis) {
		try(    
				Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SQL_UPDATE)	
				){			
			pstmt.setString(1, avis.getUsername());
			pstmt.setInt(2, avis.getRating());
			pstmt.setString(3, avis.getProductName());
			pstmt.setString(4, avis.getComment());
			pstmt.setInt(5, avis.getId());
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
