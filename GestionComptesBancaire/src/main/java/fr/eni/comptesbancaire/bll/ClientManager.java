package fr.eni.comptesbancaire.bll;

import java.util.List;

import fr.eni.comptesbancaire.bo.Client;
import fr.eni.comptesbancaire.dal.ClientDao;
import jakarta.ejb.Singleton;

@Singleton
public class ClientManager {

	private ClientDao clientDao  = new ClientDao();

	public List<Client> tousLesClients(){
		return clientDao.findAll();
	}

	public Client trouverClient(int id) {
		// TODO Auto-generated method stub
		return clientDao.findById(id);
	}
	
}
