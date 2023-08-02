package demoJPQL.dal;

import java.util.List;

import demoJPQL.bo.Article;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ArticleDao {

	EntityManagerFactory emf;
	EntityManager em;
	
	public ArticleDao() {
		emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		em = emf.createEntityManager();
	}
	
	public List<Article> findAll(){
		 TypedQuery<Article> query = em.createNamedQuery("findAll",
				 Article.class);
		 return query.getResultList();
	}
	
	public List<Article> findByTitle(String title){
		 TypedQuery<Article> query = em.createNamedQuery("findByTitle",
				 Article.class);
		 query.setParameter("title", "%"+title+"%");
		 return query.getResultList();
	}	    
	
	public void addArticle(Article article) {
		em.getTransaction().begin();
		em.persist(article);		
		em.getTransaction().commit();
	}
	
}
