// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OrderListServlet.java

package com.neuedu.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.neuedu.bean.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class OrderListServlet extends HttpServlet
{

	public OrderListServlet()
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
		String status = request.getParameter("status");
		HttpSession se = request.getSession();
		List all = (List)se.getAttribute("orderList");
		List data = null;
		if ("0".equals(status))
		{
			data = new ArrayList();
			for (Iterator iterator = all.iterator(); iterator.hasNext();)
			{
				Order order = (Order)iterator.next();
				if (order.getStatus() == 0)
					data.add(order);
			}

		} else
		{
			data = all;
		}
		Gson gson = (new GsonBuilder()).create();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(data));
		out.close();
	}
}
