package fr.eni.i18n.filter;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;


public class I18nSubDirFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		List<String> langs = List.of("fr","en","es","it");
		HttpServletRequest req = (HttpServletRequest)  request;
		String uri = req.getRequestURI();
		String path = uri.replace(req.getContextPath(), "");
		String lang = path.split("/")[1];
		
		if(langs.contains(lang)) {
			req.setAttribute("lang", lang);
			path = path.replace("/"+lang, "");
			req.getRequestDispatcher(path)
			.forward(req, response);
			return;
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}


}
