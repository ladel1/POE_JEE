package demoJSPAAvance.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import demoJSPAAvance.bo.Voiture;


public class VoitureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// création d'instances voitures
		Voiture v1 = new Voiture("Opel", "Corsa", 230);
		Voiture v2 = new Voiture("Bugatti", "Chiron", 450);
		// ajout dans context request
		request.setAttribute("v1", v1);
		request.setAttribute("v2", v2);
		// délégation vers JSP liste voitures
		request.getRequestDispatcher("/WEB-INF/liste-voiture.jsp")
		.forward(request, response);
	}


}
