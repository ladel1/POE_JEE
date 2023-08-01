package fr.eni.ecole.bo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class IdLivre implements Serializable  {
	private static final long serialVersionUID = 1L;
	private String titre;
	private String langue;
	
	public IdLivre() {}

	public IdLivre(String titre, String langue) {
		this.titre = titre;
		this.langue = langue;
	}

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	
	
	
}
