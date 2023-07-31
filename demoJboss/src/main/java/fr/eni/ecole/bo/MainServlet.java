package fr.eni.ecole.bo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager em =  emf.createEntityManager();
		
		EntityTransaction et =  em.getTransaction();
		et.begin();
		
		Quiz q = new Quiz();
		q.setNom("QUIZ JAVA SE");
		em.persist(q);
		et.commit();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

}
