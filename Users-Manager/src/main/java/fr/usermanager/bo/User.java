package fr.usermanager.bo;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
@NamedQuery(name = "loginQuery",
            query = "SELECT u FROM User u WHERE u.email LIKE :email")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 100, nullable = false, unique = true)
	private String email;
	@Column(length = 50, nullable = false, unique = true)
	private String username;
	@Column(length = 10,nullable = false)
	private String role;
	@Column(nullable = false)
	private String password;
	private LocalDate dateCreated;
	
	public User() {}

	public User(String email, String username, String password) {
		this.email = email;
		this.role = "member";
		this.username = username;
		this.password = password;
		this.dateCreated = LocalDate.now();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", role=" + role + ", password="
				+ password + ", dateCreated=" + dateCreated + "]";
	}
	
	
	
	
}
