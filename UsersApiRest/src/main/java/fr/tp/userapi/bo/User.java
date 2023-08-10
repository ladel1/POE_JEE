package fr.tp.userapi.bo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
@NamedQueries({
	@NamedQuery(name="findAll",query="SELECT u FROM User u"),
	@NamedQuery(name="deleteOne",query="DELETE FROM User u WHERE u.id = :id ")
})
public class User implements Serializable{
	private static final long serialVersionUID = -8443452436803963465L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstname;
	private String lastname;
	private String address;
	private int age;
	
	public User() { }

	public User(Integer id, String firstname, String lastname, String address, int age) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address
				+ ", age=" + age + "]";
	}

}
