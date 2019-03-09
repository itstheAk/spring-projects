package com.workbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workbook.data.VehicleType;
import com.workbook.jpa.VehicleTypeRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VehicleTypeService {
	
	@Autowired
	private VehicleTypeRepo vehicleRepo;
	
	/**
	 * Returns All Vehicle Types
	 * @return
	 */
	public List<VehicleType> getAllVehicleTypes() {
		List<VehicleType> vehicleTypes = new ArrayList<>();
		vehicleRepo.findAll().forEach(i -> vehicleTypes.add(i));
		return vehicleTypes;
	}
	
	public VehicleType addVehicleType(String vehicleType) {
		VehicleType newRow = new VehicleType();
		newRow.setType(vehicleType);
		try {
			vehicleRepo.save(newRow);
		} catch (Exception e) {
			log.error("Exception While Saving", e);
			e.printStackTrace();
		}
		return newRow;
	}

}
