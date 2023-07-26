package fr.eni.ecole.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.ecole.bo.Voiture;

@WebServlet("/home")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// création de l'instance voiture
		Voiture bugatti = new Voiture("Bugatti", "Chiron", 440, "XX-254-YY");
		// vers la JSP
		request.setAttribute("voiture", bugatti);
		// délégation
		request.getRequestDispatcher("/WEB-INF/pages/home.jsp")
			   .forward(request, response);		
	}
}
