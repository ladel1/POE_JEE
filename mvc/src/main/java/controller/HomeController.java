package controller;

import java.io.IOException;

import fr.routers.Route;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HomeController {

	@Route
	public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().print("Accueil");
	}
	
	public void contact(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().print("Contact");
	}
	

	
}
