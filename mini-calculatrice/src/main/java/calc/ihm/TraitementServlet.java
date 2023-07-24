package calc.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculer")
public class TraitementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récuperation des parapeteres
		String op1 = request.getParameter("op1");
		String op2 = request.getParameter("op2");
		String op = request.getParameter("op");
		//
		if(op1.isBlank() || op2.isBlank() ) {
			// pas valide --> Exception
			response.getWriter().write("Erreur!");
			return;
		}
		// traitement (valide)
		float op1Value = Float.parseFloat(op1);
		float op2Value = Float.parseFloat(op2);
		float results = 0;
		switch (op) {
			case "+": {
				results = op1Value+op2Value;
				break;
			}
			case "-": {
				results = op1Value-op2Value;
				break;
			}
			case "/": {
				results = op1Value/op2Value;
				break;
			}
			case "*": {
				results = op1Value*op2Value;
				break;
			}
			case "%": {
				results = op1Value%op2Value;
				break;
			}
			default: {
				System.out.println("Erreur");
			}			
		}
		response.setContentType("text/html");
		response.getWriter().write("<h1> Resultats %.2f </h1>".formatted(results));
	}

}
