package fr.eni.ecole.ihm;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

public class RequestListener implements ServletRequestListener {

    public void requestInitialized(ServletRequestEvent sre)  { 
    	 HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
    	 request.setAttribute("name", "Sarah");
         System.out.println("******   Init Request    *********");
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
         System.out.println("*********  Destroyed Request  ********");
    }
	
}
