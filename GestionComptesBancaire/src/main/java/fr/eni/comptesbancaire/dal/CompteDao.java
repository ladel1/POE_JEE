package fr.eni.comptesbancaire.dal;

import java.time.LocalDate;

import fr.eni.comptesbancaire.bo.Client;
import fr.eni.comptesbancaire.bo.Compte;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CompteDao {
	EntityManager em;
	public CompteDao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("compte_up");
		this.em = emf.createEntityManager();	
	}
	
	
	public void saveCompte(Compte compte) {
		em.getTransaction().begin();		
		em.persist(compte);
		em.getTransaction().commit();	
	}
	
}
