package com.pirelli.tech.challenge.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeasurementDTO {
	
	private String timestamp;
	private String pressure;
	private String tyrePosition;
	private String temperature;
	private String angularVelocity; 
	private String linearSpeed;
	private String vehicleModel;
}
