// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CancelServlet.java

package com.neuedu.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.neuedu.bean.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CancelServlet extends HttpServlet
{

	public CancelServlet()
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
		String orderId = request.getParameter("orderId");
		HttpSession se = request.getSession();
		List orderList = (List)se.getAttribute("orderList");
		List trainList = (List)se.getAttribute("trainList");
		for (int i = 0; i < orderList.size(); i++)
		{
			Order order = (Order)orderList.get(i);
			if (!order.getId().equals(orderId))
				continue;
			List passengerList = order.getPassengerList();
			for (int j = 0; j < passengerList.size(); j++)
			{
				Passenger passenger = (Passenger)passengerList.get(j);
				for (int k = 0; k < trainList.size(); k++)
				{
					Train train = (Train)trainList.get(k);
					if (!train.getTrainNo().equals(order.getTrain().getTrainNo()) || !train.getStartTrainDate().equals(order.getTrain().getStartTrainDate()))
						continue;
					Map tmp = train.getSeats();
					Seat seat = (Seat)tmp.get(passenger.getSeat().getSeatName());
					seat.setSeatNum(seat.getSeatNum() + 1);
					tmp.put(passenger.getSeat().getSeatName(), seat);
					train.setSeats(tmp);
					trainList.set(k, train);
					break;
				}

			}

			passengerList.clear();
			order.setOrderPrice(0.0D);
			order.setStatus(2);
			break;
		}

		se.setAttribute("trainList", trainList);
		se.setAttribute("orderList", orderList);
		String data = "1";
		Gson gson = (new GsonBuilder()).create();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(data));
		out.close();
	}
}
