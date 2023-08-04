package fr.eni.ecole.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String usernameServerSide = "adel"; 
	private String passwordServerSide = "123";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/login.jsp")
		.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usernameClientSide = request.getParameter("username");
		String passwordClientSide = request.getParameter("password");
		
		if(usernameClientSide.equals(usernameServerSide) &&
		   passwordClientSide.equals(passwordServerSide) 		
				) {
			HttpSession session = request.getSession();
			session.setAttribute("username", usernameClientSide);			
			response.sendRedirect(request.getContextPath()+"/mon-compte");
		}else {
			request.setAttribute("erreur", 
					"Le nom de l'utilisateur ou le mot de passe est incorrect!");
			request.getRequestDispatcher("/WEB-INF/login.jsp")
			.forward(request, response);
		}
		
	}
}
