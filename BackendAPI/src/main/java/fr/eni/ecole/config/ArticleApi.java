package fr.eni.ecole.config;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/articles")
public class ArticleApi {

	@GET
	public String afficher() {
		return "Bonjour !";
	}
	
}
