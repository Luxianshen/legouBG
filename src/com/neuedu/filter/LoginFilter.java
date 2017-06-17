// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LoginFilter.java

package com.neuedu.filter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter
	implements Filter
{

	public LoginFilter()
	{
	}

	public void destroy()
	{
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2)
		throws IOException, ServletException
	{
		HttpSession se = ((HttpServletRequest)request).getSession();
		if (se.getAttribute("account") == null || se.getAttribute("status") == null || ((Integer)se.getAttribute("status")).intValue() != 1)
		{
			String data = "ÇëÖØÐÂµÇÂ½£¡";
			Gson gson = (new GsonBuilder()).create();
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(gson.toJson(data));
			out.close();
		} else
		{
			arg2.doFilter(request, response);
		}
	}

	public void init(FilterConfig filterconfig)
		throws ServletException
	{
	}
}
