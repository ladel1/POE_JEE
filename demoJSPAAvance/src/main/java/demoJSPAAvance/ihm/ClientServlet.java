package demoJSPAAvance.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.wildfly.security.password.interfaces.BCryptPassword;

import demoJSPAAvance.bo.Client;

public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client> clients = new ArrayList<Client>();
		
		clients.add(new Client("De lor", "Pierre", 50));
		clients.add(new Client("Maisel", "Eri", 40));
		clients.add(new Client("DuPont", "Lucas", 20));
		clients.add(new Client("Chevalier", "Gaelle", 20));
		clients.add(new Client("De lor", "Sarah", 30));
		String [] menu = {"Home","Contact","Blog","A propos"};
		request.setAttribute("menu", menu);
		request.setAttribute("clients", clients);
		request.getRequestDispatcher("/WEB-INF/liste-clients.jsp")
		.forward(request, response);
		
	}



}
