package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Appointment {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private User id_user;

	@ManyToOne
	@JoinColumn(name = "id_manager")
	private User id_manager;

	@ManyToOne
	@JoinColumn(name = "id_department")
	private Department id_department;

	private String hour;
	private Date date;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "id_appointment")
	private Report report;
}