package fr.usermanager.filter;

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
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.usermanager.bo.User;

@WebFilter(
		urlPatterns = "/mon-compte/*",
		dispatcherTypes = {
				DispatcherType.REQUEST
		}
		)
public class F1GuardFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Simple Filter");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if(user==null) {
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect(req.getContextPath()+"/login");
			return;
		}
		// pass the request along the filter chain
		request.setAttribute("user", user);
		chain.doFilter(request, response);
	}
}
