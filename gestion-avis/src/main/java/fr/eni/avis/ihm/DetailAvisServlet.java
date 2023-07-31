package fr.eni.avis.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.avis.bll.AvisManager;
import fr.eni.avis.bo.Avis;

/**
 * Servlet implementation class DetailAvisServlet
 */
public class DetailAvisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] parts = request.getPathInfo().split("/");
		if(parts.length != 2) {
			response.sendError(404);
			return;
		}
		int id = Integer.parseInt(parts[1]);
		AvisManager avisManager = new AvisManager();
		Avis avis = avisManager.getAvis(id);
		if(avis==null) {
			response.sendError(404);
			return;
		}
		request.setAttribute("avis", avis);
		request.getRequestDispatcher("/WEB-INF/pages/detail-avis.jsp")
		.forward(request, response);
	}


}
