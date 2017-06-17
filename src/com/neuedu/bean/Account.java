// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Account.java

package com.neuedu.bean;

import java.io.Serializable;

// Referenced classes of package com.neuedu.bean:
//			Passenger

public class Account extends Passenger
	implements Serializable
{

	private String username;
	private String password;

	public Account()
	{
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String toString()
	{
		return (new StringBuilder("Account [password=")).append(password).append(", username=").append(username).append("]").toString();
	}
}
