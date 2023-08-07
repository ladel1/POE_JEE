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

import java.io.IOException;

import fr.usermanager.bo.User;


@WebFilter(urlPatterns = "/mon-compte/admin/*",
			dispatcherTypes = {
					DispatcherType.REQUEST
			}
		)
public class GuardAdminFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Admin Filtre");
		User user = (User) request.getAttribute("user");
		if(!user.getRole().equals("admin")) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect(req.getContextPath()+"/login");
			return;
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}


}
