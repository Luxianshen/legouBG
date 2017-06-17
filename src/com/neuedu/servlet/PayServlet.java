// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PayServlet.java

package com.neuedu.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.neuedu.bean.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class PayServlet extends HttpServlet
{

	public PayServlet()
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
		for (int i = 0; i < orderList.size(); i++)
		{
			Order order = (Order)orderList.get(i);
			if (!order.getId().equals(orderId))
				continue;
			order.setStatus(1);
			break;
		}

		String data = "1";
		Gson gson = (new GsonBuilder()).create();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(data));
		out.close();
	}
}
