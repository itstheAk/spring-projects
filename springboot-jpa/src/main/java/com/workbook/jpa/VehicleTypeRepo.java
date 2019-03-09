package com.workbook.jpa;

import org.springframework.data.repository.CrudRepository;

import com.workbook.data.VehicleType;

public interface VehicleTypeRepo extends CrudRepository<VehicleType, Long>{

}
