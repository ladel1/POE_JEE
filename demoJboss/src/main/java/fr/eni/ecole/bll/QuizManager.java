package fr.eni.ecole.bll;

import fr.eni.ecole.bo.Quiz;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class QuizManager { 
	/** Start Singleton */
	// étape 1
	private static QuizManager instance;
	// étape 2
	private QuizManager() {}
	// étape 3
	public static QuizManager getInstance() {
		if(instance==null) {
			instance = new QuizManager();
		}
		return instance;
	}
	/** end Singleton */

	
	/**  Start Logic  **/
	public void ajouterQuestion(Quiz q) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		// start transaction
		em.getTransaction().begin();
		em.persist(q);		
		em.getTransaction().commit();
	}
}
