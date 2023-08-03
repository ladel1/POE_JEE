package fr.eni.comptesbancaire.dal;

import java.util.List;

import fr.eni.comptesbancaire.bo.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ClientDao {

	EntityManager em;
	
	public ClientDao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("compte_up");
		this.em = emf.createEntityManager();	
	}
	
	public List<Client> findAll(){
		TypedQuery<Client> query = em.createNamedQuery("findAll",Client.class);
		return query.getResultList();
	}

	public Client findById(int id) {
		return this.em.find(Client.class,id);
	}
	
	
}
