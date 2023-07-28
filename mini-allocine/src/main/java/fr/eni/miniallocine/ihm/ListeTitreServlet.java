package fr.eni.miniallocine.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import fr.eni.miniallocine.bll.TitreManager;
import fr.eni.miniallocine.bo.Titre;


public class ListeTitreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TitreManager titreManager = new TitreManager();
		List<Titre> titres = titreManager.afficherTitres();
		request.setAttribute("titres", titres);
		request.getRequestDispatcher("/WEB-INF/pages/titres.jsp")
		.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		TitreManager titreManager = new TitreManager();
		titreManager.supprimerTitre(id);
		resp.sendRedirect(req.getContextPath()+"/titres");
	}

}
