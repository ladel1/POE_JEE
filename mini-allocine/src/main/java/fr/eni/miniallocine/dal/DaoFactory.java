package fr.eni.miniallocine.dal;

import fr.eni.miniallocine.dal.jdbc.TitreDaoImpl;

public class DaoFactory {

	public static TitreDAO getTitreDao() {
		return new TitreDaoImpl();
	}
	
}
