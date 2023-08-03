package fr.eni.comptesbancaire.ihm;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import fr.eni.comptesbancaire.bll.ClientManager;
import fr.eni.comptesbancaire.bll.CompteManager;
import fr.eni.comptesbancaire.bo.Client;
import fr.eni.comptesbancaire.bo.Compte;

@WebServlet("/clients")
public class ListClientsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	private CompteManager compteManager;
	@Inject
	private ClientManager clientManager;	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client> clients =clientManager.tousLesClients();
		request.setAttribute("clients", clients);
		request.getRequestDispatcher("/WEB-INF/pages/liste-clients.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
