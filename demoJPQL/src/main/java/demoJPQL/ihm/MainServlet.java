package demoJPQL.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import demoJPQL.bll.ArticleManager;
import demoJPQL.bo.Article;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// creation de l'instance article
		Article article = new Article();
		article.setAuteur("adel");
		article.setTitre("Formation Symfony API");
		article.setContenu("blabalablablabla");
		article.setDateCreation(LocalDate.now());
		
		ArticleManager aManager = new ArticleManager();
		// l'ajout de l'article dans la bdd
		aManager.AjouterArticle(article);
		// recuperation des articles
		///List<Article> articles = aManager.tousLesArticles();
		List<Article> articles = aManager.trouverArticlesParTitre("symfony");
		System.out.println(articles);
		response.getWriter().append("Works!");
	}
}
