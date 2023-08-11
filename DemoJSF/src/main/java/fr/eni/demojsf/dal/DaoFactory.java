package fr.eni.demojsf.dal;

public class DaoFactory {

	public static ClientDao getClientDao() {
		return new ClientDaoImpl();
	}
	
}
