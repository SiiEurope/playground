/* Copyright (c) 2018 by net-linx; All rights reserved */
package com.sii.playground.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sii.playground.entities.Car;
import com.sii.playground.entities.CarManager;

/**
 * @author Stefan Stiller
 */
@WebServlet("/car")
public class CarServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		boolean create=ServletUtils.toBoolean(req.getParameter("create"));
		if (!create)
		{
			Long id=ServletUtils.toLong(req.getParameter("id"));
			if (id==null)
			{
				req.setAttribute("error", "Parameter is missing!");
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
				return;
			}
			Car car=CarManager.getInstance().get(id);
			if (car==null)
			{
				req.setAttribute("error", "Car not found!");
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
				return;
			}
			req.setAttribute("car", car);
			req.setAttribute("manufacturer", car.getManufacturer());
			req.setAttribute("model", car.getModel());
			req.setAttribute("yearBuilt", car.getYearBuilt()!=null ? car.getYearBuilt().toString() : null);
			req.setAttribute("milage", car.getMilage()!=null ? ServletUtils.formatInt(car.getMilage(), req.getLocale()) : null);
		}
		req.getRequestDispatcher("/car.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Car car;
		boolean create=ServletUtils.toBoolean(req.getParameter("create"));
		if (!create)
		{
			Long id=ServletUtils.toLong(req.getParameter("id"));
			if (id==null)
			{
				req.setAttribute("error", "Parameter is missing!");
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
				return;
			}
			car=CarManager.getInstance().get(id);
			if (car==null)
			{
				req.setAttribute("error", "Car not found!");
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
				return;
			}
		}
		else car=new Car();

		Map<String, List<String>> fieldErrors=new HashMap<>();
		String manufacturer=req.getParameter("manufacturer");
		String model=req.getParameter("model");
		String yearBuilt=req.getParameter("yearBuilt");
		String milage=req.getParameter("milage");
		req.setAttribute("manufacturer", manufacturer);
		req.setAttribute("model", model);
		req.setAttribute("yearBuilt", yearBuilt);
		req.setAttribute("milage", milage);

		if (StringUtils.isBlank(manufacturer)) addFieldError(fieldErrors, "manufacturer", "Manufacturer is required!");
		if (StringUtils.isBlank(model)) addFieldError(fieldErrors, "model", "Model is required!");
		Integer yearBuiltI=null;
		if (!StringUtils.isBlank(yearBuilt))
		{
			try
			{
				yearBuiltI=Integer.parseInt(yearBuilt);
			}
			catch (NumberFormatException e)
			{
				addFieldError(fieldErrors, "yearBuilt", "Year expected!");
			}
		}
		Integer milageI=null;
		if (!StringUtils.isBlank(milage))
		{
			try
			{
				milageI=ServletUtils.parseInt(milage, req.getLocale());
			}
			catch (ParseException e)
			{
				addFieldError(fieldErrors, "milage", "Integer expected!");
			}
		}
		if (!fieldErrors.isEmpty())
		{
			req.setAttribute("fieldErrors", fieldErrors);
			req.getRequestDispatcher("/car.jsp").forward(req, resp);
			return;
		}
		car.setManufacturer(manufacturer.trim());
		car.setModel(model.trim());
		car.setYearBuilt(yearBuiltI);
		car.setMilage(milageI);
		CarManager.getInstance().save(car);
		resp.sendRedirect(req.getContextPath()+"/index.jsp");
	}

	private void addFieldError(Map<String, List<String>> fieldErrors, String property, String message)
	{
		fieldErrors.computeIfAbsent(property, k -> new ArrayList<>()).add(message);
	}

}
