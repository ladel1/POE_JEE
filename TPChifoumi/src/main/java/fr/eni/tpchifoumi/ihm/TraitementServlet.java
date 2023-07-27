package fr.eni.tpchifoumi.ihm;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("")
public class TraitementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final static int CHI = 0;
	private final static int FOU = 1;
	private final static int MI = 2;
	private final static String [] messages = {
		"Ordinateur a gagné",
		"Nul",
		"Utilisateur a gagné",
		
	};	
	Random rand = new Random();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String str = null;
//		str.charAt(0);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/tentative.jsp");
		rd.forward(req, resp);
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("userChoice");
		
		// validation
		
		// userChoice
		int userChoice = Integer.parseInt(user);
		// ServerChoice
		int serverChoice = rand.nextInt(CHI, MI+1);
		// User vs. Server
		int result;
		if( userChoice == serverChoice) {
			// draw
			result = 0;
		}else if (
				userChoice == CHI && serverChoice == MI ||
				userChoice == FOU && serverChoice == CHI||
				userChoice == MI  && serverChoice == FOU
				) {
			// User win
			result = 1;
		}else {
			// user loose
			result = -1;
		}
		
		request.setAttribute("message",messages[result+1]);
		request.setAttribute("userChoice", userChoice);
		request.setAttribute("serverChoice", serverChoice);
		
		request.getRequestDispatcher("/WEB-INF/jsp/resultat.jsp")
		.forward(request, response);
	}

}
