package fr.eni.ecole.ihm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.ecole.bo.Patient;
import fr.eni.ecole.bo.Personne;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");	
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Patient m = new Patient("dddd", "qsdf", 30, "3215468", "blalbalab");
		em.persist(m);
		em.getTransaction().commit();
		
		TypedQuery<Personne> q = em.createNamedQuery("findAllPatients",Personne.class);
		q.setParameter("nom", "dddd");
		Patient pp = (Patient) q.getSingleResult();
		System.out.println(pp);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


}
