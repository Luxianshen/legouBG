// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TicketPassengerListServlet.java

package com.neuedu.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.neuedu.bean.Account;
import com.neuedu.bean.Passenger;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class TicketPassengerListServlet extends HttpServlet
{

	public TicketPassengerListServlet()
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
		HttpSession se = request.getSession();
		List passengerList = (List)se.getAttribute("passengerList");
		Account account = (Account)se.getAttribute("account");
		List data = new ArrayList();
		data.add(account);
		for (int i = 0; i < passengerList.size(); i++)
			data.add((Passenger)passengerList.get(i));

		Gson gson = (new GsonBuilder()).create();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(data));
		out.close();
	}
}
