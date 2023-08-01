package fr.eni.ecole.bo;

import java.io.Serializable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("m")
public class Medecin extends Personne implements Serializable {

	private String specialite;
	private float tarif;

	public Medecin() {
		// TODO Auto-generated constructor stub
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public float getTarif() {
		return tarif;
	}

	public void setTarif(float tarif) {
		this.tarif = tarif;
	}
	
	
	
}
