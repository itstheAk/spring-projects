package com.explore.batch.components;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.explore.batch.data.Car;
import com.explore.batch.repo.CarRepository;

@Component
public class DataWriter implements ItemWriter<Car>{

	@Autowired
	private CarRepository repo;
	
	@Override
	public void write(List<? extends Car> items) throws Exception {
		System.out.println("DataWriter::write going to save cars");
		repo.saveAll(items);
		System.out.println("DataWriter::write saved cars");
	}

}
