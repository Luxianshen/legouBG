// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Seat.java

package com.neuedu.bean;

import java.io.Serializable;

public class Seat
	implements Serializable
{

	private String seatName;
	private int seatNum;
	private double seatPrice;
	private String seatNo;

	public Seat()
	{
	}

	public String getSeatName()
	{
		return seatName;
	}

	public void setSeatName(String seatName)
	{
		this.seatName = seatName;
	}

	public int getSeatNum()
	{
		return seatNum;
	}

	public void setSeatNum(int seatNum)
	{
		this.seatNum = seatNum;
	}

	public double getSeatPrice()
	{
		return seatPrice;
	}

	public void setSeatPrice(double seatPrice)
	{
		this.seatPrice = seatPrice;
	}

	public String getSeatNo()
	{
		return seatNo;
	}

	public void setSeatNo(String seatNo)
	{
		this.seatNo = seatNo;
	}

	public String toString()
	{
		return (new StringBuilder("Seat [seatName=")).append(seatName).append(", seatNo=").append(seatNo).append(", seatNum=").append(seatNum).append(", seatPrice=").append(seatPrice).append("]").toString();
	}
}
