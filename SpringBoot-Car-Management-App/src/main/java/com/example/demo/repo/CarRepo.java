package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CarEntity;

public interface CarRepo extends JpaRepository<CarEntity, Integer> {
	
	@Query(value="Select * from car where name=:name", nativeQuery = true)
	public List<CarEntity> findCarByName(@Param("name") String name);
	
	
	@Query(value="Select * from car where model=:model", nativeQuery = true)
	public List<CarEntity> findCarByModel(@Param("model") String model);
	
	@Query(value="Select * from car where year=:year", nativeQuery = true)
	public List<CarEntity> findCarByYear(@Param("year") int year);

}
