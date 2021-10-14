package com.jpa.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String name;
	private String city;
	private String domain;

	public User(int id, String name, String city, String domain) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.domain = domain;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", city=" + city + ", domain=" + domain + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getdomain() {
		return domain;
	}

	public void setdomain(String domain) {
		this.domain = domain;
	}
}
