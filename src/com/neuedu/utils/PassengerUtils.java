// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PassengerUtils.java

package com.neuedu.utils;

import com.neuedu.bean.Passenger;
import java.util.ArrayList;
import java.util.List;

public class PassengerUtils
{

	public PassengerUtils()
	{
	}

	public static List getPassengerList()
	{
		List passengerList = new ArrayList();
		Passenger p = new Passenger();
		p.setId("37010519880414805X");
		p.setIdType("身份证");
		p.setName("陈伟飞");
		p.setTel("13912341200");
		p.setType("成人");
		passengerList.add(p);
		Passenger p2 = new Passenger();
		p2.setId("310101199204163983");
		p2.setIdType("身份证");
		p2.setName("哎米米");
		p2.setTel("13912341234");
		p2.setType("学生");
		passengerList.add(p2);
		return passengerList;
	}

	public static List saveOrUpdatePassenger(List passengerList, Passenger passenger)
	{
		boolean flg = true;
		for (int i = 0; i < passengerList.size(); i++)
		{
			Passenger oldPassenger = (Passenger)passengerList.get(i);
			if (!oldPassenger.getId().equals(passenger.getId()) || !oldPassenger.getIdType().equals(passenger.getIdType()))
				continue;
			passengerList.set(i, passenger);
			flg = false;
			break;
		}

		if (flg)
			passengerList.add(passenger);
		return passengerList;
	}

	public static Passenger findPassenger(List passengerList, Passenger passenger)
	{
		Passenger p = null;
		for (int i = 0; i < passengerList.size(); i++)
		{
			Passenger oldPassenger = (Passenger)passengerList.get(i);
			if (!oldPassenger.getId().equals(passenger.getId()) || !oldPassenger.getIdType().equals(passenger.getIdType()))
				continue;
			p = oldPassenger;
			break;
		}

		return p;
	}

	public static List removePassenger(List passengerList, Passenger passenger)
	{
		for (int i = 0; i < passengerList.size(); i++)
		{
			Passenger oldPassenger = (Passenger)passengerList.get(i);
			if (!oldPassenger.getId().equals(passenger.getId()) || !oldPassenger.getIdType().equals(passenger.getIdType()))
				continue;
			passengerList.remove(i);
			break;
		}

		return passengerList;
	}
}
