// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OrderUtils.java

package com.neuedu.utils;

import com.neuedu.bean.*;
import java.io.PrintStream;
import java.util.*;

public class OrderUtils
{

	public OrderUtils()
	{
	}

	public static Order getOrder(Train train, Seat seat, List passengers, int id)
	{
		Order order = new Order();
		order.setTrain(train);
		Random rd = new Random();
		int n = rd.nextInt(80) + 1;
		int m = rd.nextInt(10) + 1;
		for (int i = 0; i < passengers.size(); i++)
		{
			Seat newSeat = new Seat();
			newSeat.setSeatName(seat.getSeatName());
			newSeat.setSeatNum(seat.getSeatNum());
			newSeat.setSeatPrice(seat.getSeatPrice());
			Passenger tmp = (Passenger)passengers.get(i);
			String seatNo = (new StringBuilder(String.valueOf(m))).append("车").append(n++).append("号").toString();
			newSeat.setSeatNo(seatNo);
			Seat trainSeat = (Seat)train.getSeats().get(seat.getSeatName());
			trainSeat.setSeatNum(trainSeat.getSeatNum() - 1);
			train.getSeats().put(seat.getSeatName(), trainSeat);
			tmp.setSeat(newSeat);
			passengers.set(i, tmp);
		}

		order.setPassengerList(passengers);
		Calendar c = Calendar.getInstance();
		order.setId((new StringBuilder(String.valueOf(c.get(1)))).append(decode(id)).toString());
		order.setStatus(0);
		order.setOrderTime(new Date());
		double price = 0.0D;
		for (Iterator iterator = passengers.iterator(); iterator.hasNext();)
		{
			Passenger passenger = (Passenger)iterator.next();
			if ("成人".equals(passenger.getType()))
				price += seat.getSeatPrice();
			else
			if ("学生".equals(passenger.getType()))
				price += seat.getSeatPrice() / 2D;
			else
			if ("儿童".equals(passenger.getType()))
				price += seat.getSeatPrice() / 2D;
			else
				price += seat.getSeatPrice();
		}

		order.setOrderPrice(price);
		return order;
	}

	public static String decode(long id)
	{
		String alphabet = "123456789abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
		int base_count = alphabet.length();
		String encoded = "";
		long div;
		for (; id >= (long)base_count; id = div)
		{
			div = id / (long)base_count;
			long mod = id % (long)base_count;
			encoded = (new StringBuilder(String.valueOf(alphabet.charAt((int)mod)))).append(encoded).toString();
		}

		if (id > 0L)
			encoded = (new StringBuilder(String.valueOf(alphabet.charAt((int)id)))).append(encoded).toString();
		return encoded;
	}

	public static void main(String args[])
	{
		long id = 0x75e74788L;
		System.out.println((new StringBuilder(String.valueOf((new Date()).getTime()))).append(",").append(decode(0x12dd532L)).toString());
	}
}
