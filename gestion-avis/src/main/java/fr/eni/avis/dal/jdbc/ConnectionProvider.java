package fr.eni.avis.dal.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {

	private static DataSource dataSource = null;
	
	static {		 
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool");			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}	
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
}
