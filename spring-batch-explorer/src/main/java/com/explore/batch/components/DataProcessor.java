package com.explore.batch.components;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.explore.batch.data.Car;

@Component
public class DataProcessor implements ItemProcessor<Car, Car>{

	@Override
	public Car process(Car item) throws Exception {
		System.out.println("DataProcessor::process reading Cars");
		return item;
	}

}
