package fr.tp.userapi.dal;

import java.util.List;

import fr.tp.userapi.bo.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class UserDaoImpl implements UserDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("API_PU");
	private EntityManager em = emf.createEntityManager();
	
	
	@Override
	public void insert(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();		
	}

	@Override
	public List<User> findAll() {
		TypedQuery<User> typedQuery= em.createNamedQuery("findAll", User.class);
		return typedQuery.getResultList();
	}

	@Override
	public User findOne(int id) { 
		return em.find(User.class,id);
	}

}
