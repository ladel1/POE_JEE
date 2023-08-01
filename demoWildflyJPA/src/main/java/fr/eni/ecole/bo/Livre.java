package fr.eni.ecole.bo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Livre {

	@EmbeddedId
	private IdLivre idLivre;
	
	private int nombrePage;
	private String description;
	
}
