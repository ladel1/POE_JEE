package fr.ecole.eni.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// la route vers notre servlet MainServlet
@WebServlet("/home-avec-annotation")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.write("<h1>"+ request.getHeader("Accept-Language") +"</h1>");;
		out.write("<h1>"+ request.getHeader("Host") +"</h1>");;
	}

}
