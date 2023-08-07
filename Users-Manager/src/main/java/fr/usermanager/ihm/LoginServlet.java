package fr.usermanager.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import fr.usermanager.bll.UserManager;
import fr.usermanager.bll.exception.BLLException;
import fr.usermanager.bo.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/login.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			User user = UserManager.getInstance().login(email, password);
			HttpSession session = request.getSession();
			user.setPassword("");
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/mon-compte");
		} catch (BLLException e) {
			if(e.getErrors().size()>0) {				
				request.setAttribute("erreurs", e.getErrors());
			}else {
				request.setAttribute("erreurs", List.of(e.getMessage()));/// SQLException!!!
			}
			// Delegation
			doGet(request, response);
			e.printStackTrace();
		}
		
	}

}
