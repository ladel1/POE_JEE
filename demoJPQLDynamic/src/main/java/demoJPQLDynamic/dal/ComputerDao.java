package demoJPQLDynamic.dal;

import java.util.List;
import java.util.Map;

import demoJPQLDynamic.bo.Computer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ComputerDao {

	EntityManagerFactory emf;
	EntityManager em;
	String jpql = "SELECT c FROM Computer c WHERE ";
	
	public ComputerDao() {
		emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		em = emf.createEntityManager();
	}
	
	public List<Computer> filter(Map<String,String> c){
		
		c.forEach((String key,String val)->{
			//System.out.println(key+"  "+val);
			jpql += key+" LIKE :"+key+" AND ";
		});		
		jpql = jpql.substring(0, jpql.length()-5);
		// créer compilé la requete
		TypedQuery<Computer> query=  em.createQuery(jpql,Computer.class);
		// ajouter les params à la requete
		c.forEach((String key,String val)->{
			query.setParameter(key, "%"+val+"%");		
		});		
		
		return query.getResultList();
	}
	
	
	public void saveComputer(Computer computer) {
		em.getTransaction().begin();		
		em.persist(computer);
		em.getTransaction().commit();
	}
 	
	
}
