package fr.eni.ecole.bo;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Livre implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IdLivre idLivre;	
	private int nombrePage;
	private String description;
	
	public Livre() { }

	public IdLivre getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(IdLivre idLivre) {
		this.idLivre = idLivre;
	}

	public int getNombrePage() {
		return nombrePage;
	}

	public void setNombrePage(int nombrePage) {
		this.nombrePage = nombrePage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
