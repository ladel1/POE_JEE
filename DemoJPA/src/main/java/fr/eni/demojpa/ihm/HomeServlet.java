package fr.eni.demojpa.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.eni.demojpa.bo.Produit;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et  =  em.getTransaction();		
		et.begin();
		// creation de l'instance
		Produit p = new Produit();
		p.setNom("Oppo");
		p.setDescription("blabalbalablablab");
		p.setPrix(1200);
		// persister
		em.persist(p);
		
		et.commit();
		
		response.getWriter().append("Works!");
	}


}
