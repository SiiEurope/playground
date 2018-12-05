/* Copyright (c) 2018 by net-linx; All rights reserved */
package com.sii.playground.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sii.playground.entities.Car;
import com.sii.playground.entities.CarManager;

/**
 * @author Stefan Stiller
 */
@WebServlet("/delete-car")
public class DeleteCarServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
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
		CarManager.getInstance().delete(car);
		resp.sendRedirect(req.getContextPath()+"/index.jsp");
	}
}
