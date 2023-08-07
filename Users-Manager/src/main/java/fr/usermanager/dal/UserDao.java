package fr.usermanager.dal;

import fr.usermanager.bo.User;
import fr.usermanager.helper.PasswordHasher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class UserDao {

	EntityManager em;
	
	public UserDao() {
		em = Persistence.createEntityManagerFactory("USERS_PU")
						.createEntityManager();
	}
	
	public User selectUserByEmail(String email) throws Exception {
		try {			
			TypedQuery<User> userQuery = em.createNamedQuery("loginQuery",User.class);
			userQuery.setParameter("email", email);
			return userQuery.getSingleResult();///  null ou une exception
		}catch(NoResultException e) {
			throw new Exception("L'email ou le mot de passe est incorrect!");			
		}
	}
	
	public void createUser(User user) {
		em.getTransaction().begin();				
		em.persist(user);
		em.getTransaction().commit();;
	}
	
}
