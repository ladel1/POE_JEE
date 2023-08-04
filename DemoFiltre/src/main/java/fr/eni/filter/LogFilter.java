package fr.eni.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;


public class LogFilter extends HttpFilter implements Filter {
       
	public void destroy() {
		System.out.println("******** Destroy Filter **********");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		System.out.println("Dans le filtre et Avant la servlet ");
		String [] nav = {"Home","Contact","Connexion","Inscription"};
		request.setAttribute("nav", nav);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("*********** Init Filter **********");
	}

}
