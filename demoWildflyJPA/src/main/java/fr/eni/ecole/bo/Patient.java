package fr.eni.ecole.bo;

import java.io.Serializable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
@Entity
@DiscriminatorValue("patient")
public class Patient extends Personne implements Serializable {

	private String nss;
	private String diagnostic;
	
	public Patient() {
		// TODO Auto-generated constructor stub
	}
	
	public Patient(String nom, String prenom, int age, String nss, String diagnostic) {
		super(nom, prenom, age);
		this.nss = nss;
		this.diagnostic = diagnostic;
	}







	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	@Override
	public String toString() {
		return "Patient [nss=" + nss + ", diagnostic=" + diagnostic + ", toString()=" + super.toString() + "]";
	}

	
	
	
}
