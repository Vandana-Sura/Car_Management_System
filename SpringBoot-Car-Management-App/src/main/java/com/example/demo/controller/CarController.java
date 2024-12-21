package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Car;
import com.example.demo.service.CarService;

@RestController
@CrossOrigin("*")
@RequestMapping("/myapp")
public class CarController {
	
	@Autowired
	CarService carService;
	
	@GetMapping(value="/car", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Car> getAllCars(){
		return carService.getAllCars();
	}
	
	@GetMapping(value="/car/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Car> getCarByCarName(@PathVariable("name") String name){
		return carService.getCarByCarName(name);
	}
	
	@GetMapping(value="/car/model/{model}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Car> getCarByModelName(@PathVariable("model") String model){
		return carService.getCarByModelName(model);
	}
	
	@GetMapping(value="/car/year/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Car> getCarByYear(@PathVariable("year") int year){
		return carService.getCarByYear(year);
	}
	
	@PostMapping(value="/car", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE) 
	public Car addCar(@RequestBody Car car) {
		return carService.addCar(car);
	}
	
	@PutMapping(value="/car/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Car updateCar(@RequestBody Car car,@PathVariable("id") int id) {
		return carService.updateCar(car,id);
	}
	
	@DeleteMapping("/car")
	public String deleteAllCars() {
		return carService.deleteAllCars();
	}
	
	@DeleteMapping("/car/{id}")
	public String deleteCarById(@PathVariable("id") int id) {
		return carService.deleteCarById(id);
	}
}
