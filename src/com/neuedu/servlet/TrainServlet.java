// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TrainServlet.java

package com.neuedu.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.neuedu.utils.TrainListUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class TrainServlet extends HttpServlet
{

	public TrainServlet()
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
		String fromStationName = request.getParameter("fromStationName");
		String toStationName = request.getParameter("toStationName");
		String startTrainDate = request.getParameter("startTrainDate");
		String trainNo = request.getParameter("trainNo");
		HttpSession se = request.getSession();
		List all = (List)se.getAttribute("trainList");
		com.neuedu.bean.Train train = TrainListUtils.findByDateAndTrainNo(all, startTrainDate, trainNo);
		Gson gson = (new GsonBuilder()).create();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(train));
		out.close();
	}
}
