package demoJPQL.bll;

import java.util.List;

import demoJPQL.bo.Article;
import demoJPQL.dal.ArticleDao;

public class ArticleManager {

	private ArticleDao articleDao;
	
	public ArticleManager() {
		articleDao = new ArticleDao();
	}
	
	public List<Article> tousLesArticles(){
		return articleDao.findAll();
	}
	
	public void AjouterArticle(Article article) {
		// validation des données!!!
		articleDao.addArticle(article);
	}
	
	public List<Article> trouverArticlesParTitre(String titre) {		
		return articleDao.findByTitle(titre);
	}
	
}
