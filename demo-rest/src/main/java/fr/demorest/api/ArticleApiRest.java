package fr.demorest.api;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/articles")

public class ArticleApiRest {

	List<Article> articles ;
	
	public ArticleApiRest() {
		articles = List.of(
				new Article(1, "DELL PC i9 Core","balbalabalbalb", "Laptop",1200),
				new Article(2, "HP PC i7 Core","balbalabalbalb", "Laptop",1800),
				new Article(3, "ACER PC i5 Core","balbalabalbalb", "Laptop",1600),
				new Article(4, "HP Ecran 24°","balbalabalbalb", "Ecran",500),
				new Article(5, "Samsung S21 5G","balbalabalbalb", "Smartphone",1300),
				new Article(6, "Iphone 12","balbalabalbalb", "Smartphone",1900)				
				);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Article> getArticles() {		
		return articles;
	}

	
	@GET
	@Path("/{cle:[0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Article getDetail(@PathParam("cle") int id) {
		return articles.get(id-1);
	}
	
	
}
