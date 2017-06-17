// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   EncodingFilter.java

package com.neuedu.filter;

import java.io.IOException;
import javax.servlet.*;

public class EncodingFilter
	implements Filter
{

	public EncodingFilter()
	{
	}

	public void destroy()
	{
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
		throws IOException, ServletException
	{
		arg0.setCharacterEncoding("utf-8");
		arg1.setCharacterEncoding("utf-8");
		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig filterconfig)
		throws ServletException
	{
	}
}
