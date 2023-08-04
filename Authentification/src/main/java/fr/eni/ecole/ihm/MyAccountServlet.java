package fr.eni.ecole.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


public class MyAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("username")==null) {
			// redirection vers login car pas de session
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		// y a une session
		response.getWriter().print("Bonjour "+session.getAttribute("username"));
	}

}
