package fr.eni.avis.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.avis.bll.AvisManager;
import fr.eni.avis.bll.exception.BLLException;
import fr.eni.avis.bo.Avis;

/**
 * Servlet implementation class UpdateAvisServlet
 */
public class UpdateAvisServlet extends HttpServlet {
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
		request.getRequestDispatcher("/WEB-INF/pages/update-avis.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {	
			String [] parts = request.getPathInfo().split("/");
			if(parts.length != 2) {
				response.sendError(404);
				return;
			}
			int id = Integer.parseInt(parts[1]);			
			Avis avis = new Avis(request.getParameter("username"), 
					Integer.parseInt(request.getParameter("rating")),
					request.getParameter("product_name"), 
					request.getParameter("comment"));
			avis.setId(id);			
			AvisManager avisManager = new AvisManager();
			avisManager.updateAvis(avis);
			response.sendRedirect(request.getContextPath()+"/avis");
		}catch(NumberFormatException e ) {
			request.setAttribute("erreurs", "Le champs note est obligatoire!");
			request.getRequestDispatcher("/WEB-INF/pages/add-avis.jsp")
			.forward(request, response);	
		}catch(BLLException e){
			request.setAttribute("erreurs", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/pages/add-avis.jsp")
			.forward(request, response);	
			e.printStackTrace();
		}
		
		
	}

}
