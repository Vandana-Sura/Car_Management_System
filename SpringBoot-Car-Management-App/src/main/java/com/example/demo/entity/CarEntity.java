package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="Car")
public class CarEntity {
	
	@Id
	@GeneratedValue
	public int Id;
	@Column(name="name")
	public String name;
	
	@Column(name="model")
	public String model;
	
	@Column(name="year")
	public int year;
	
	@Column(name="color")
	public String color;
	
	@Column(name="fuel_type")
	public String fuelType;

}
