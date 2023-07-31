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
 * Servlet implementation class AddAvisServlet
 */
public class AddAvisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/add-avis.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {			
			Avis avis = new Avis(request.getParameter("username"), 
					Integer.parseInt(request.getParameter("rating")),
					request.getParameter("product_name"), 
					request.getParameter("comment"));
			
			AvisManager avisManager = new AvisManager();
			avisManager.addAvis(avis);
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
