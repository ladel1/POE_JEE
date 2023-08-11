package fr.eni.demojsf.dal;

import java.util.List;

import fr.eni.demojsf.bo.Client;
import fr.eni.demojsf.helper.EMF;
import jakarta.persistence.EntityManager;

public class ClientDaoImpl implements ClientDao {

	EntityManager em = EMF.getEntityManager();
	
	@Override
	public void insert(Client client) {
		em.getTransaction().begin();
		em.persist(client);
		em.getTransaction().commit();
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		
	}

}
