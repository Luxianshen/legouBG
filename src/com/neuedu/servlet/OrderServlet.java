// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OrderServlet.java

package com.neuedu.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.neuedu.bean.*;
import com.neuedu.utils.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class OrderServlet extends HttpServlet
{

	public OrderServlet()
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
		String trainNo = request.getParameter("trainNo");
		String startTrainDate = request.getParameter("startTrainDate");
		String seatName = request.getParameter("seatName");
		String ids[] = request.getParameterValues("id");
		String idTypes[] = request.getParameterValues("idType");
		HttpSession se = request.getSession();
		Account account = (Account)se.getAttribute("account");
		List passengerList = (List)se.getAttribute("passengerList");
		List trainList = (List)se.getAttribute("trainList");
		int orderId = ((Integer)se.getAttribute("orderId")).intValue();
		se.setAttribute("orderId", Integer.valueOf(orderId + 1));
		Train train = TrainListUtils.findByDateAndTrainNo(trainList, startTrainDate, trainNo);
		Seat seat = (Seat)train.getSeats().get(seatName);
		List passengers = new ArrayList();
		for (int i = 0; i < ids.length; i++)
		{
			Passenger tmp = new Passenger();
			tmp.setId(ids[i]);
			tmp.setIdType(idTypes[i]);
			if (account.getIdType().equals(idTypes[i]) && account.getId().equals(ids[i]))
			{
				passengers.add(account);
			} else
			{
				Passenger tmp2 = PassengerUtils.findPassenger(passengerList, tmp);
				if (tmp2 != null)
					passengers.add(tmp2);
			}
		}

		com.neuedu.bean.Order data = OrderUtils.getOrder(train, seat, passengers, orderId);
		List orderList = (List)se.getAttribute("orderList");
		orderList.add(0, data);
		se.setAttribute("orderList", orderList);
		List newTrainList = TrainListUtils.updateByTrain(trainList, train);
		se.setAttribute("trainList", newTrainList);
		Gson gson = (new GsonBuilder()).create();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(data));
		out.close();
	}
}
