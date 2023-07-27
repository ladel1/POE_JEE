package fr.eni.miniallocine.bo;

import java.time.LocalDate;

public class Titre {
	// attributs
	private int id;
	private String nom;
	private String synopsis;
	private String realisateur;
	private String genre;
	private LocalDate dateSortie;
	private int duree;
	private boolean type;
	// constructeurs
	public Titre() {}

	public Titre(String nom, String synopsis, String realisateur, String genre, LocalDate dateSortie, int duree,
			boolean type) {
		this.nom = nom;
		this.synopsis = synopsis;
		this.realisateur = realisateur;
		this.genre = genre;
		this.dateSortie = dateSortie;
		this.duree = duree;
		this.type = type;
	}

	public Titre(int id, String nom, String synopsis, String realisateur, String genre, LocalDate dateSortie, int duree,
			boolean type) {
		this(nom,synopsis,realisateur,genre,dateSortie,duree,type);
		this.id = id;
	}
	// getters & setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public LocalDate getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}
	
	
	
}
