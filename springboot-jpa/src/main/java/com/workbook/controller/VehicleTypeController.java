package com.workbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workbook.data.VehicleType;
import com.workbook.service.VehicleTypeService;

@RestController
@RequestMapping("/types")
public class VehicleTypeController {
	
	@Autowired
	private VehicleTypeService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VehicleType> getTypes() {
		return service.getAllVehicleTypes();
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public VehicleType addVehicleType(@RequestParam(name="typeName") String vehicleTypeName) {
		return service.addVehicleType(vehicleTypeName);
	}

}
