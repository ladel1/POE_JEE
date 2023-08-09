package fr.tp.userapi.bo;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = -8443452436803963465L;
	
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
