package com.pirelli.tech.challenge.service;

import java.util.ArrayList;
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
        List<String> cars = measurementRepository.getAllCars();
        return cars;
    }
    
    public List<MeasurementDTO> getAllMeasurementsSingleCar(String vehicleModel){
    	List<Measurement> measurementsSingleCar = measurementRepository.getAllMeasurementsSingleCar(vehicleModel);
    	List<MeasurementDTO> measurementsSingleCarDTO = new ArrayList<MeasurementDTO>();
    	
    	for(Measurement m : measurementsSingleCar) {
    		// this if is used for data cleaning process to fix inaccurate (negative) pressure and speed values
    		if(Double.valueOf(m.getPressure()) >= 0 && Double.valueOf(m.getLinearSpeed()) >=0) {
    			measurementsSingleCarDTO.add(measurementMapper.toDto(m));
    		}
    	}
    	
    	return measurementsSingleCarDTO;
    }

}
