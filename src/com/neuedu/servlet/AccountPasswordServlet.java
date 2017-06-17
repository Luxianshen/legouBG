// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   AccountPasswordServlet.java

package com.neuedu.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.neuedu.bean.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AccountPasswordServlet extends HttpServlet
{

	public AccountPasswordServlet()
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
		String action = request.getParameter("action");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		HttpSession se = request.getSession();
		Account account = (Account)se.getAttribute("account");
		String data = "1";
		if ("query".equals(action))
		{
			if (!account.getPassword().equals(oldPassword))
				data = "0";
		} else
		{
			account.setPassword(newPassword);
			se.setAttribute("account", account);
		}
		Gson gson = (new GsonBuilder()).create();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(data));
		out.close();
	}
}
