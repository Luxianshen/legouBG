// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PassengerServlet.java

package com.neuedu.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.neuedu.bean.Passenger;
import com.neuedu.utils.PassengerUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class PassengerServlet extends HttpServlet
{

	public PassengerServlet()
	{
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		String name = request.getParameter("姓名");
		String idType = request.getParameter("证件类型");
		String id = request.getParameter("证件号码");
		String type = request.getParameter("乘客类型");
		String tel = request.getParameter("电话");
		String action = request.getParameter("action");
		Passenger passenger = new Passenger();
		passenger.setId(id);
		passenger.setIdType(idType);
		passenger.setName(name);
		passenger.setTel(tel);
		passenger.setType(type);
		HttpSession se = request.getSession();
		List passengerList = (List)se.getAttribute("passengerList");
		String data = "1";
		if ("new".equals(action))
		{
			if (PassengerUtils.findPassenger(passengerList, passenger) != null)
			{
				data = "0";
			} else
			{
				PassengerUtils.saveOrUpdatePassenger(passengerList, passenger);
				se.setAttribute("passengerList", passengerList);
			}
		} else
		if ("update".equals(action))
		{
			PassengerUtils.saveOrUpdatePassenger(passengerList, passenger);
			se.setAttribute("passengerList", passengerList);
		} else
		if ("remove".equals(action))
			PassengerUtils.removePassenger(passengerList, passenger);
		else
			data = "-1";
		Gson gson = (new GsonBuilder()).create();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(data));
		out.close();
	}
}
