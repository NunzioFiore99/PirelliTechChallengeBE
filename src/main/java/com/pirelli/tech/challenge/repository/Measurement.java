package com.pirelli.tech.challenge.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "measurement")
public class Measurement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="timestamp")
	private String timestamp;
	
	@Column(name="pressure")
	private String pressure;
	
	@Column(name="tyrePosition")
	private String tyrePosition;
	
	@Column(name="temperature")
	private String temperature;
	
	@Column(name="angularVelocity")
	private String angularVelocity;
	
	@Column(name="linearSpeed")
	private String linearSpeed;
	
	@Column(name="vehicleModel")
	private String vehicleModel;
}

