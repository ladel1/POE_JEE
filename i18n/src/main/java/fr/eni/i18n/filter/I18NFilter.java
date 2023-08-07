package fr.eni.i18n.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class I18NFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {	
		// place your code here
//		HttpServletRequest req = (HttpServletRequest) request;
//		String lang = req.getParameter("lang");
//		if(lang==null || lang.isBlank()) {
//			chain.doFilter(request, response);
//			return;
//		}
//		HttpSession session = req.getSession();
//		session.setAttribute("lang", lang);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}


}
