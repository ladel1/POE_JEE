package fr.eni.comptesbancaire.bo;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="comptes")
public class Compte implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String numeroCompte;
	private float solde;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Client client;
	
	public Compte() {}
	
	public Compte(String numeroCompte, float solde, Client client) {
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.client = client;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", numeroCompte=" + numeroCompte + ", solde=" + solde + "]";
	}
	
	
	
	
}
