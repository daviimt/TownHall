package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Report {
	@Id
	@GeneratedValue
	private int id;

	@OneToOne
	@JoinColumn(name = "id_appointment")
	private Appointment id_appointment;

	private String data;
	private boolean resolution;
}