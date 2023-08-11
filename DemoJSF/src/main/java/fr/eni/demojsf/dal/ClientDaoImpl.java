package fr.eni.demojsf.dal;

import java.util.List;

import fr.eni.demojsf.bo.Client;
import fr.eni.demojsf.helper.EMF;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

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
		TypedQuery<Client> tQuery = em.createNamedQuery("findAll",Client.class);
		return tQuery.getResultList();
	}

	@Override
	public Client findOne(int id) { 
		return em.find(Client.class, id);
	}

	@Override
	public void remove(Client client) {
		em.getTransaction().begin();		
		em.remove(client);		
		em.getTransaction().commit();		
	}

}
