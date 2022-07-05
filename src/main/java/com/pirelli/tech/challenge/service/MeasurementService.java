package com.pirelli.tech.challenge.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pirelli.tech.challenge.dto.MeasurementDTO;
import com.pirelli.tech.challenge.mapper.MeasurementMapper;
import com.pirelli.tech.challenge.repository.Measurement;
import com.pirelli.tech.challenge.repository.MeasurementRepository;

@Service
public class MeasurementService {
	
	@Autowired
    private MeasurementRepository measurementRepository;
	
	@Autowired
    private MeasurementMapper measurementMapper;

    public MeasurementDTO getById(Long id) {
        Optional<Measurement> resultOpt = measurementRepository.findById(id);
        return resultOpt.isPresent() ? measurementMapper.toDto(resultOpt.get()) : null;
    }

    public void create(MeasurementDTO dto) {
    	measurementRepository.save(measurementMapper.toEntity(dto));
    }
    
    public List<String> getAllCars() {
        List<String> carsList = measurementRepository.getAllCars();
        return carsList;
    }
    
    public List<MeasurementDTO> getAllMeasurementsSingleCar(String vehicleModel){
    	List<Measurement> measurementsSingleCarList = measurementRepository.getAllMeasurementsSingleCar(vehicleModel);
    	List<MeasurementDTO> measurementsSingleCarDTOList = new ArrayList<MeasurementDTO>();
    	
    	for(Measurement m : measurementsSingleCarList) {
    		// this if is used for data cleaning process to fix inaccurate (negative) pressure and speed values
    		if(Double.valueOf(m.getPressure()) >= 0 && Double.valueOf(m.getLinearSpeed()) >=0) {
    			measurementsSingleCarDTOList.add(measurementMapper.toDto(m));
    		}
    	}
    	
    	return measurementsSingleCarDTOList;
    }
    
    public List<MeasurementDTO> getAllMeasurementsMultipleCars(String carsListString){
    	List<String> carsList = new ArrayList<String>(Arrays.asList(carsListString.split(","))); //Cars selected
    	List<MeasurementDTO> measurementsMultipleCarsDTOList = new ArrayList<MeasurementDTO>(); //All measurements of all cars DTO
    	
    	for(String car : carsList) {
    		List<Measurement> measurementsSingleCarList = measurementRepository.getAllMeasurementsSingleCar(car); //All measurements single car
    		for(Measurement m : measurementsSingleCarList) {
        		// this if is used for data cleaning process to fix inaccurate (negative) pressure and speed values
        		if(Double.valueOf(m.getPressure()) >= 0 && Double.valueOf(m.getLinearSpeed()) >=0) {
        			measurementsMultipleCarsDTOList.add(measurementMapper.toDto(m));
        		}
        	}
    	}
    	
    	return measurementsMultipleCarsDTOList;
    }

}
