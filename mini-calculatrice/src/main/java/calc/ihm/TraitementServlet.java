package calc.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class TraitementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		req.getRequestDispatcher("/WEB-INF/calculatrice.jsp").forward(req, resp);
		
	}
	
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
		request.setAttribute("result", results);
		request.getRequestDispatcher("/WEB-INF/calculatrice.jsp").forward(request, response);
	}

}
