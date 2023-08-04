package fr.usermanager.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.usermanager.bll.UserManager;
import fr.usermanager.bll.exception.BLLException;
import fr.usermanager.bo.User;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/register.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserManager.getInstance().registerUser(
					new User(request.getParameter("email"), 
							 request.getParameter("username"), 
							 request.getParameter("password"))
					);
			// la redirection vers la page de la connexion
			response.sendRedirect(request.getContextPath()+"/login");
		} catch (BLLException e) {
			request.setAttribute("erreurs", e.getErrors());
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp")
			.forward(request, response);
			e.printStackTrace();
		}
		
	}

}
