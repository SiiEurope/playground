/* Copyright (c) 2018 by net-linx; All rights reserved */
package com.sii.playground.entities;

/**
 * @author Stefan Stiller
 */
public class Car extends BaseEntity 
{
	private String manufacturer;
	private String model;
	private Integer yearBuilt;
	private Integer milage;
	
	public Car()
	{
	}

	public String getManufacturer()
	{
		return manufacturer;
	}

	public void setManufacturer(String manufacturer)
	{
		this.manufacturer=manufacturer;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model=model;
	}
	
	public Car manufacturer(String manufacturer)
	{
		setManufacturer(manufacturer);
		return this;
	}

	public Car model(String model)
	{
		setModel(model);
		return this;
	}

	public Car yearBuilt(int year)
	{
		setYearBuilt(year);
		return this;
	}

	public Car milage(int milage)
	{
		setMilage(milage);
		return this;
	}

	public Integer getYearBuilt()
	{
		return yearBuilt;
	}

	public void setYearBuilt(Integer yearBuilt)
	{
		this.yearBuilt=yearBuilt;
	}

	public Integer getMilage()
	{
		return milage;
	}

	public void setMilage(Integer milage)
	{
		this.milage=milage;
	}
}
