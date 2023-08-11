package fr.eni.demojsf.helper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMF {
	private static EntityManagerFactory emf;
	
	private EMF() {}

	public static EntityManager getEntityManager() {
		if(emf==null) {
			emf = Persistence.createEntityManagerFactory("JSF_PU");
		}
		return emf.createEntityManager();
	}
	
}
