package fr.eni.comptesbancaire.ihm;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.comptesbancaire.bll.ClientManager;
import fr.eni.comptesbancaire.bo.Client;

@WebServlet("/clients/details/*")
public class DetailsClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private ClientManager clientManager;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] parts = request.getPathInfo().split("/");
		if(parts.length != 2) {
			response.sendError(404);
			return;
		}
		int id = Integer.parseInt(parts[1]);
		Client client = clientManager.trouverClient(id);
		request.setAttribute("client", client);
		request.getRequestDispatcher("/WEB-INF/pages/details-client.jsp")
		.forward(request, response);
	}


}
