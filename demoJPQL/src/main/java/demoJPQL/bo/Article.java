package demoJPQL.bo;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "articles")
@NamedQueries(
		{
			@NamedQuery(name = "findAll",
					    query = "SELECT a FROM Article a"),
			@NamedQuery(name = "findByTitle",
		    query = "SELECT a FROM Article a WHERE a.titre LIKE :title")
		}
		)
public class Article implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private String titre;
	private String contenu;
	private String auteur;
	private LocalDate dateCreation;
	
	public Article() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", auteur=" + auteur
				+ ", dateCreation=" + dateCreation + "]";
	}
	
	

}
