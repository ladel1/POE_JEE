package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/*")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		List<Object> route = getControllerFromPath(path);
		Class<?> _class = (Class<?>) route.get(0);
		try {
			Constructor<?> cons = _class.getDeclaredConstructor();
			Object inst = cons.newInstance();
			Method m = _class.getMethod((String)route.get(1),
					HttpServletRequest.class,
					HttpServletResponse.class);
			m.invoke(inst,request,response);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {			
			e.printStackTrace();
		}
	}
	// router
	private List<Object> getControllerFromPath(String path) {
		Map<String,List<Object>> router = new HashMap<String, List<Object>>();	
		// route ( url => Controller & méthode )
		router.put("/home", List.of(HomeController.class,"index") );
		router.put("/*", List.of(HomeController.class,"index") );
		router.put("/contact", List.of(HomeController.class,"contact") );
		return router.get(path);
	}
}
