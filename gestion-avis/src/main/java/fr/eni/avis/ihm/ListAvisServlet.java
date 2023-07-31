package fr.eni.avis.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import fr.eni.avis.bll.AvisManager;
import fr.eni.avis.bo.Avis;

/**
 * Servlet implementation class ListAvisServlet
 */
public class ListAvisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AvisManager avisManager = new AvisManager();
		List<Avis> listAvis = avisManager.getAllAvis();
		request.setAttribute("listAvis", listAvis);
		request.getRequestDispatcher("/WEB-INF/pages/list-avis.jsp")
		.forward(request, response);
	}


}
