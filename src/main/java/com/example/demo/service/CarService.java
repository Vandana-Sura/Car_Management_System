package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.Car;

public interface CarService {
	
	public List<Car> getAllCars();
	
	public List<Car> getCarByCarName(String name);
	
	public List<Car> getCarByModelName(String model);
	
	public List<Car> getCarByYear(int year);
	
	public Car addCar( Car car);
	
	public Car updateCar(Car car, int id);
	
	public String deleteAllCars();
	
	public String deleteCarById(int id);




}
