package fr.eni.miniallocine.dal;

import fr.eni.miniallocine.dal.jdbc.TitreDaoImpl;
import fr.eni.miniallocine.dal.txt.TitreDaoTxtImpl;

public class DaoFactory {

	public static TitreDAO getTitreDao() {
		return new TitreDaoImpl();
		//return new TitreDaoTxtImpl();
	}
	
}
