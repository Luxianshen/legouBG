// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Order.java

package com.neuedu.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.neuedu.bean:
//			Train

public class Order
	implements Serializable
{

	private String id;
	private List passengerList;
	private Train train;
	private int status;
	private Date orderTime;
	private double orderPrice;

	public Order()
	{
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public List getPassengerList()
	{
		return passengerList;
	}

	public void setPassengerList(List passengerList)
	{
		this.passengerList = passengerList;
	}

	public Train getTrain()
	{
		return train;
	}

	public void setTrain(Train train)
	{
		this.train = train;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public Date getOrderTime()
	{
		return orderTime;
	}

	public void setOrderTime(Date orderTime)
	{
		this.orderTime = orderTime;
	}

	public double getOrderPrice()
	{
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice)
	{
		this.orderPrice = orderPrice;
	}

	public String toString()
	{
		return (new StringBuilder("Order [id=")).append(id).append(", orderPrice=").append(orderPrice).append(", orderTime=").append(orderTime).append(", passengerList=").append(passengerList).append(", status=").append(status).append(", train=").append(train).append("]").toString();
	}
}
