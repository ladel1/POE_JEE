package demoJSPAAvance.bo;

import java.io.Serializable;

public class Voiture implements Serializable {
	private static final long serialVersionUID = 1L;
	private String marque;
	private String modele;
	private int vitesseMax;
	
	public Voiture() {}

	public Voiture(String marque, String modele, int vitesseMax) {
		this.marque = marque;
		this.modele = modele;
		this.vitesseMax = vitesseMax;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getVitesseMax() {
		return vitesseMax;
	}

	public void setVitesseMax(int vitesseMax) {
		this.vitesseMax = vitesseMax;
	}
	
	
	
}
