/* Copyright (c) 2018 by net-linx; All rights reserved */
package com.sii.playground.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sii.playground.entities.CarManager;

/**
 * @author Stefan Stiller
 */
@WebServlet("/reset")
public class ResetServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		CarManager.getInstance().reset();
		resp.sendRedirect(req.getContextPath()+"/index.jsp");
	}
}
