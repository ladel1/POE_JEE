package fr.eni.ecole.bo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quiz implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String question;
	private String option1, option2, option3;
	private boolean reponse1, reponse2, reponse3;
	
	public Quiz() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Quiz(String nom, String question, String option1, String option2, String option3, boolean reponse1,
			boolean reponse2, boolean reponse3) {
		super();
		this.nom = nom;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.reponse1 = reponse1;
		this.reponse2 = reponse2;
		this.reponse3 = reponse3;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public boolean isReponse1() {
		return reponse1;
	}

	public void setReponse1(boolean reponse1) {
		this.reponse1 = reponse1;
	}

	public boolean isReponse2() {
		return reponse2;
	}

	public void setReponse2(boolean reponse2) {
		this.reponse2 = reponse2;
	}

	public boolean isReponse3() {
		return reponse3;
	}

	public void setReponse3(boolean reponse3) {
		this.reponse3 = reponse3;
	}


	
}
