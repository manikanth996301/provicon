package com.example.Provicon.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
	@Column(nullable  = false)
private String name;
	@Column(nullable  = false,unique=true)
private String email;
	@Column(nullable  = false)
private String password;
	public User() {
		super();
	}
	public User(long id, String name, String email, String passwod) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = passwod;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswod() {
		return password;
	}
	public void setPasswod(String passwod) {
		this.password = passwod;
	}

}
