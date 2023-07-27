package fr.eni.miniallocine.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.eni.miniallocine.bll.TitreManager;
import fr.eni.miniallocine.bo.Titre;
import fr.eni.miniallocine.dal.jdbc.ConnectionProvider;
// /home
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/ajouter-titre.jsp")
		.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// récuperation les données du formulaire (ajout film)
		String nom = req.getParameter("nom");
		String synopsis = req.getParameter("synopsis");
		String realisateur = req.getParameter("realisateur");
		String genre = req.getParameter("genre");
		String date_sortie = req.getParameter("date_sortie");
		String duree = req.getParameter("duree");
		String type = req.getParameter("type");
		// Création objet titre
		Titre titre = new Titre(nom, synopsis, realisateur,
				genre, LocalDate.parse(date_sortie), 
				Integer.parseInt(duree), 
				Boolean.valueOf(type));
		// faire appel à titre manager pour persister
		TitreManager titreManager = new TitreManager();
		titreManager.ajouterTitre(titre);
	}
	
}
