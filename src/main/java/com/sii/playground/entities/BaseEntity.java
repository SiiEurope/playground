/* Copyright (c) 2016 by net-linx; All rights reserved */
package com.sii.playground.entities;

/**
 * @author Stefan Stiller
 */
public class BaseEntity implements Identifiable
{
	public static final String ID="id";
	
	private Long id;
	
	@Override
	public Long getId()
	{
		return id;
	}

	protected void setId(Long id)
	{
		this.id=id;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this==o) return true;
		if (o==null || getClass()!=o.getClass()) return false;

		BaseEntity that=(BaseEntity) o;

		return id!=null && id.equals(that.id);
	}

	@Override
	public int hashCode()
	{
		return id!=null ? id.hashCode() : 0;
	}
}

