package com.pirelli.tech.challenge.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pirelli.tech.challenge.dto.MeasurementDTO;
import com.pirelli.tech.challenge.service.MeasurementService;

@RestController
@RequestMapping("api/v1/pirelli")
public class MeasurementController {
	
		@Autowired
		private MeasurementService measurementService;
		

	    @GetMapping("/{id}")
	    public ResponseEntity<MeasurementDTO> getById(@PathVariable(name = "id") Long id) {
	        return ResponseEntity.ok(measurementService.getById(id));
	    }

	    @PostMapping
	    public ResponseEntity<?> create(@RequestBody MeasurementDTO dto) {
	    	measurementService.create(dto);
	        return ResponseEntity.ok(dto);
	    }
	    
	    @GetMapping("/getAllCars")
	    public ResponseEntity<List<String>> getAllCars(){
	    	return ResponseEntity.ok(measurementService.getAllCars());
	    }
	    
	    @GetMapping("/getAllMeasurementsSingleCar/{vehicleModel}")
	    public ResponseEntity<List<MeasurementDTO>> getAllMeasurementsSingleCar(@PathVariable(name = "vehicleModel") String vm){
	    	return ResponseEntity.ok(measurementService.getAllMeasurementsSingleCar(vm));
	    }

}
