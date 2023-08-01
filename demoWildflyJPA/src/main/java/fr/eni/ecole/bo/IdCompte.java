package fr.eni.ecole.bo;

import java.io.Serializable;

public class IdCompte implements Serializable {
	
	private String numCompte;
	private String typeCompte;
	public IdCompte() {
		// TODO Auto-generated constructor stub
	}

	public IdCompte(String numCompte, String typeCompte) {
		this.numCompte = numCompte;
		this.typeCompte = typeCompte;
	}

	public String getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}
	public String getTypeCompte() {
		return typeCompte;
	}
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	
	
	
	
}
