package fr.usermanager.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.usermanager.bo.User;


public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user =(User) request.getAttribute("user");
		response.getWriter()
		.write("Username: %s; Email: %s; Role: %s".formatted(
					user.getUsername(),
					user.getEmail(),
					user.getRole()
				));
	}



}
