package fr.demorest.api;

import java.io.Serializable;

public class Article implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nom;
	private String description;
	private String categorie;
	private float prix;
	
	public Article() { }
	
	public Article(Integer id, String nom, String description, String categorie, float prix) {
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.categorie = categorie;
		this.prix = prix;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	
	
}
