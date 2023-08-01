package fr.eni.ecole.bo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Spectateur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	private String nom;
	private String prenom;
	@ManyToMany
	@JoinTable(name = "films_spectateurs",
			   joinColumns = @JoinColumn(name="spec_id"),
			   inverseJoinColumns = @JoinColumn(name="film_id")
			)	
	private List<Film> filmsVus;
	
	public Spectateur() { }

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Film> getFilmsVus() {
		return filmsVus;
	}

	public void setFilmsVus(List<Film> filmsVus) {
		this.filmsVus = filmsVus;
	}
	
	
}
