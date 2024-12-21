package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Car;
import com.example.demo.entity.CarEntity;
import com.example.demo.repo.CarRepo;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	CarRepo carRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<Car> getAllCars() {
		List<CarEntity> carEntityList = carRepo.findAll();
		
		return convertEntityListIntoDTOList(carEntityList);
	}

	@Override
	public List<Car> getCarByCarName(String name) {
		List<CarEntity> carEntityList = carRepo.findCarByName(name);
		return convertEntityListIntoDTOList(carEntityList);
	}

	@Override
	public List<Car> getCarByModelName(String model) {
		List<CarEntity> carEntityList = carRepo.findCarByModel(model);
		return convertEntityListIntoDTOList(carEntityList);
	}

	@Override
	public List<Car> getCarByYear(int year) {
		List<CarEntity> carEntityList = carRepo.findCarByYear(year);
		return convertEntityListIntoDTOList(carEntityList);
	}

	@Override
	public Car addCar(Car car) {
		carRepo.save(convertCarDTOIntoEntity(car));
		return car;
	}

	@Override
	public Car updateCar(Car car, int id) {
		Optional<CarEntity> optionalcarEntity = carRepo.findById(id);
		if(optionalcarEntity.isPresent()) {
			CarEntity updateCarEntity = optionalcarEntity.get();
			//Car updateCarDto = convertEntityIntoDTO(carEntity);
			updateCarEntity.setName(car.getName());
			updateCarEntity.setModel(car.getModel());
			updateCarEntity.setYear(car.getYear());
			updateCarEntity.setColor(car.getColor());
			updateCarEntity.setFuelType(car.getFuelType());
			carRepo.save(updateCarEntity);
			
		}
		return null;
	}

	@Override
	public String deleteAllCars() {
		carRepo.deleteAll();
		return "All Cars are Deleted Successfully ";
	}

	@Override
	public String deleteCarById(int id) {
		carRepo.deleteById(id);
		return "Deleted Car with ID: "+ id + " Successfully";
	}

	private CarEntity convertCarDTOIntoEntity(Car car) {
		TypeMap<Car,CarEntity> typeMap = modelMapper.typeMap(Car.class, CarEntity.class);
		CarEntity carEntity = modelMapper.map(car, CarEntity.class);
		return carEntity;
	}
	private Car convertEntityIntoDTO(CarEntity carEntity) {
		TypeMap<CarEntity,Car> typeMap = modelMapper.typeMap(CarEntity.class, Car.class);
		Car car = modelMapper.map(carEntity, Car.class);
		return car;
	}

	private List<Car> convertEntityListIntoDTOList(List<CarEntity> carEntityList) {
		List<Car> advertisesList = new ArrayList<>();
		for (CarEntity carEntity : carEntityList) {
			TypeMap<CarEntity, Car> typeMap = modelMapper.typeMap(CarEntity.class, Car.class);
			Car car = modelMapper.map(carEntity, Car.class);
			advertisesList.add(car);
		}

		return advertisesList;
	}
}
