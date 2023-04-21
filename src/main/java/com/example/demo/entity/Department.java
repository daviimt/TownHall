package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Department {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int description;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id_department")
	private List<Appointment> appointmentsList;
}