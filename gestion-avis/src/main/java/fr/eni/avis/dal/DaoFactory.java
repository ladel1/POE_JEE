package fr.eni.avis.dal;

import fr.eni.avis.dal.jdbc.AvisDaoImpl;

public class DaoFactory {

	public static AvisDao getAvisDao() {
		return new AvisDaoImpl();
	}
	
}
