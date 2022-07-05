package com.pirelli.tech.challenge.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


@Repository
public interface MeasurementRepository extends CrudRepository<Measurement, Long> { 
	
	@Query("select m from measurement m where m.id = :id ") 
	public Optional<Measurement> findById(@Param("id") Long id);
	
	@Query("select distinct m.vehicleModel from measurement m")
	public List<String> getAllCars();
	
	//	@Query("select m from measurement m where m.vehicleModel = :vehicleModel orderby m.timestamp asc")
	@Query("select m from measurement m where m.vehicleModel = :vehicleModel")
	public List<Measurement> getAllMeasurementsSingleCar(String vehicleModel);

}
