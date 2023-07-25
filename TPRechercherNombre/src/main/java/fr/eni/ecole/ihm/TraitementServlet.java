package fr.eni.ecole.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/traitement")
public class TraitementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Random rand = new Random();
	private Integer serverChoice = null; 
	private boolean win = false;
	
	@Override
	public void init() throws ServletException {
		serverChoice = rand.nextInt(10)+1;	
		System.out.println(serverChoice);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userChoice = request.getParameter("nombre");
		// userChoice.isBlank() <====> userChoice.trim().isEmpty()
		if(userChoice.isBlank()) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		// valide
		int userChoiceConverted = Integer.parseInt(userChoice);
		if(serverChoice==userChoiceConverted && win == false) {
			win = true;
			response.sendRedirect(request.getContextPath()+"/victoire.html");
		}else {
			response.sendRedirect(request.getContextPath()+"/echec.html");
		}
		
	}

}
