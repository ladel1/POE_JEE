package fr.eni.ecole.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		PrintWriter out = response.getWriter();
		out.println("<h1>Salut</h1>");
		response.sendRedirect("/TPRechercherNombre/victoire.html");
//		out.flush();
//		try {Thread.sleep(2000);} catch (InterruptedException e) {}
//		out.write("<h1>Je suis</h1>");
//		out.flush();
//		try {Thread.sleep(2000);} catch (InterruptedException e) {}	
//		out.write("Une Servlet");
//		out.close();
	}

}
