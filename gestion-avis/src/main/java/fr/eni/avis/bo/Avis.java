package fr.eni.avis.bo;

import java.time.LocalDate;

public class Avis  { // POJO

	private Integer id;
	private String username;
	private int rating;
	private String productName;
	private LocalDate dateCreated;
	private String comment;
	
	public Avis() {}
	
	

	public Avis(String username, int rating, String productName, String comment) {
		super();
		this.username = username;
		this.rating = rating;
		this.productName = productName;
		this.comment = comment;
	}



	public Avis(Integer id, String username, int rating, String productName, LocalDate dateCreated, String comment) {
		super();
		this.id = id;
		this.username = username;
		this.rating = rating;
		this.productName = productName;
		this.dateCreated = dateCreated;
		this.comment = comment;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Avis [id=" + id + ", username=" + username + ", rating=" + rating + ", productName=" + productName
				+ ", dateCreated=" + dateCreated + ", comment=" + comment + "]";
	}
	
	
	
}
