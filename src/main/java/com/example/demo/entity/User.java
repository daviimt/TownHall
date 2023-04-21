package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	private String name, surname, dni;
	private boolean enabled;
	private String role;
	private String token;
	private int id_department;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id_user")
	private List<Appointment> appointmentsList;
}