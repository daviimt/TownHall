package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	private boolean enabled;
	private String role;
	private String token;
	private int id_department;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id_user")
	private List<Appointment> appointmentsList;

	public User() {
		super();
	}

	public User(int id, String username, String password, boolean enabled, String role, String token,
			int id_department) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.token = token;
		this.id_department = id_department;
	}

	public User(int id, String username, String password, boolean enabled, String role, String token, int id_department,
			List<Appointment> appointmentsList) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.token = token;
		this.id_department = id_department;
		this.appointmentsList = appointmentsList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getId_department() {
		return id_department;
	}

	public void setId_department(int id_department) {
		this.id_department = id_department;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", role=" + role + ", token=" + token + ", id_department=" + id_department + "]";
	}

}
