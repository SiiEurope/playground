/* Copyright (c) 2018 by net-linx; All rights reserved */
package com.sii.playground.entities;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Stefan Stiller
 */
public class CarManager
{
	private static final CarManager instance=new CarManager();
	private Map<Long, Car> cars=new LinkedHashMap<>(); 
	private static long nextId;

	public static CarManager getInstance()
	{
		return instance;
	}
	

	public CarManager()
	{
		reset();
	}
	
	public void reset()
	{
		nextId=1;
		cars.clear();
		
		save(new Car().manufacturer("Volkswagen").model("Up").yearBuilt(2014).milage(64059));
		save(new Car().manufacturer("Audi").model("A6").yearBuilt(2015).milage(79071));
		save(new Car().manufacturer("Audi").model("A6").yearBuilt(2017).milage(26391));
		save(new Car().manufacturer("Volkswagen").model("Tiguan").yearBuilt(2015).milage(69376));
		save(new Car().manufacturer("Nissan").model("Qashqai").yearBuilt(2018).milage(10));
		save(new Car().manufacturer("Volkswagen").model("T6").yearBuilt(2018).milage(4000));
		save(new Car().manufacturer("Opel").model("Corsa").yearBuilt(2010).milage(17100));
		save(new Car().manufacturer("Hyundai").model("i30").yearBuilt(2010).milage(120000));
		save(new Car().manufacturer("Opel").model("Meriva").yearBuilt(2010).milage(104429));
	}

	public void save(Car car)
	{
		if (car.getId()==null) car.setId(nextId++);
		cars.put(car.getId(), car);
	}

	public void delete(Car car)
	{
		if (car.getId()!=null) cars.remove(car.getId());
	}

	public Car get(long id)
	{
		return cars.get(id);
	}

	public Collection<? extends Car> getAll()
	{
		return cars.values();
	}
}
