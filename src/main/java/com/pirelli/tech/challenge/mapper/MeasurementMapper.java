package com.pirelli.tech.challenge.mapper;

import org.springframework.stereotype.Component;

import com.pirelli.tech.challenge.dto.MeasurementDTO;
import com.pirelli.tech.challenge.repository.Measurement;

@Component
public class MeasurementMapper {
	
	 public MeasurementDTO toDto(Measurement entity) {
		 MeasurementDTO dto = new MeasurementDTO();
	     dto.setTimestamp(entity.getTimestamp());
	     dto.setPressure(entity.getPressure());
	     dto.setTyrePosition(entity.getTyrePosition());
	     dto.setTemperature(entity.getTemperature());
	     dto.setAngularVelocity(entity.getAngularVelocity());
	     dto.setLinearSpeed(entity.getLinearSpeed());
	     dto.setVehicleModel(entity.getVehicleModel());
	     return dto;
	 }

	 public Measurement toEntity(MeasurementDTO dto) {
		 Measurement entity = new Measurement();
	     entity.setTimestamp(dto.getTimestamp());
	     entity.setPressure(dto.getPressure());
	     entity.setTyrePosition(dto.getTyrePosition());
	     entity.setTemperature(dto.getTemperature());
	     entity.setAngularVelocity(dto.getAngularVelocity());
	     entity.setLinearSpeed(dto.getLinearSpeed());
	     entity.setVehicleModel(dto.getVehicleModel());
	     return entity;
	 }
}
