package fr.eni.ecole.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie [] cookies = request.getCookies();
		
		if(cookies==null) {
			Cookie cookie = new Cookie("visiteur", "true");
			response.addCookie(cookie);
			response.getWriter().append("Bonjour");
			return;
		}		
		response.getWriter().append("Re-Bonjour");
		
		
	}


}
