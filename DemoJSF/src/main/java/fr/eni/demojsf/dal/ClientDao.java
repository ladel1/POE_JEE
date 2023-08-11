package fr.eni.demojsf.dal;

import java.util.List;

import fr.eni.demojsf.bo.Client;

public interface ClientDao {

	void insert(Client client);
	List<Client> findAll();
	Client findOne(int id);
	void remove(Client client);
	
}
