package fr.eni.ecole.ihm;

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

import fr.eni.ecole.bll.QuizManager;
import fr.eni.ecole.bo.Quiz;


public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.getRequestDispatcher("/WEB-INF/home.jsp")
		.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Quiz  q = new Quiz(req.getParameter("nom"), 
				req.getParameter("question"),
				req.getParameter("op1"), 
				req.getParameter("op2"), 
				req.getParameter("op3"), 
				Boolean.parseBoolean(req.getParameter("reponse1")), 
				Boolean.parseBoolean(req.getParameter("reponse2")), 
				Boolean.parseBoolean(req.getParameter("reponse3"))
				);
		QuizManager.getInstance().ajouterQuestion(q);
	}
	

}
