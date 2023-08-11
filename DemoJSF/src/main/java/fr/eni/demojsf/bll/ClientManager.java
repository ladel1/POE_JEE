package fr.eni.demojsf.bll;

import java.util.List;

import fr.eni.demojsf.bo.Client;
import fr.eni.demojsf.dal.ClientDao;
import fr.eni.demojsf.dal.DaoFactory;

public class ClientManager {// Singleton
	
	private static ClientManager instance;
	private ClientManager() {}
	public static ClientManager getInstance() {
		if(instance==null) {
			instance = new ClientManager();
		}
		return instance;
	}
	
	/**
	 * Logique de l'app
	 */
	
	private ClientDao clientDao = DaoFactory.getClientDao();	
	public void addClient(Client client) {
		clientDao.insert(client);
	}
	public List<Client> getClients() {
		// TODO Auto-generated method stub
		return clientDao.findAll();
	}
	
	public void removeClient(Client client) {
		clientDao.remove(client);
	}
	public Client getOneClient(int id) {		
		return clientDao.findOne(id);
	}
	
}
