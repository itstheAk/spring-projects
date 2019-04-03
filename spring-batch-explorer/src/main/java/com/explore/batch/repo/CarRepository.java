package com.explore.batch.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.explore.batch.data.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

}
