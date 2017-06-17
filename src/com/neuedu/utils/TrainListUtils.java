// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TrainListUtils.java

package com.neuedu.utils;

import com.neuedu.bean.Seat;
import com.neuedu.bean.Train;
import java.util.*;

public class TrainListUtils
{

	public TrainListUtils()
	{
	}

	public static List getTrainList()
	{
		Calendar c = Calendar.getInstance();
		List trainList = new ArrayList();
		for (int i = 0; i < 3; i++)
		{
			c.add(5, 1);
			Train train1 = new Train();
			train1.setTrainNo("G108");
			train1.setStartTime("04:47");
			train1.setArriveTime("14:46");
			train1.setDayDifference(0);
			train1.setDurationTime("9小时59分");
			train1.setStartTrainDate((new StringBuilder(String.valueOf(c.get(1)))).append("-").append(c.get(2) + 1).append("-").append(c.get(5)).toString());
			train1.setSeats(getRandomSeats(3));
			trainList.add(train1);
			Train train2 = new Train();
			train2.setTrainNo("D29");
			train2.setStartTime("07:00");
			train2.setArriveTime("11:48");
			train2.setDayDifference(0);
			train2.setDurationTime("4小时48分");
			train2.setStartTrainDate((new StringBuilder(String.valueOf(c.get(1)))).append("-").append(c.get(2) + 1).append("-").append(c.get(5)).toString());
			train2.setSeats(getRandomSeats(4));
			trainList.add(train2);
			Train train3 = new Train();
			train3.setTrainNo("D5");
			train3.setStartTime("07:05");
			train3.setArriveTime("11:55");
			train3.setDayDifference(0);
			train3.setDurationTime("4小时50分");
			train3.setStartTrainDate((new StringBuilder(String.valueOf(c.get(1)))).append("-").append(c.get(2) + 1).append("-").append(c.get(5)).toString());
			train3.setSeats(getRandomSeats(4));
			trainList.add(train3);
			Train train4 = new Train();
			train4.setTrainNo("T297");
			train4.setStartTime("12:00");
			train4.setArriveTime("20:45");
			train4.setDayDifference(0);
			train4.setDurationTime("8小时45分");
			train4.setStartTrainDate((new StringBuilder(String.valueOf(c.get(1)))).append("-").append(c.get(2) + 1).append("-").append(c.get(5)).toString());
			train4.setSeats(getRandomSeats(3));
			trainList.add(train4);
			Train train5 = new Train();
			train5.setTrainNo("K291");
			train5.setStartTime("16:55");
			train5.setArriveTime("01:30");
			train5.setDayDifference(1);
			train5.setDurationTime("8小时35分");
			train5.setStartTrainDate((new StringBuilder(String.valueOf(c.get(1)))).append("-").append(c.get(2) + 1).append("-").append(c.get(5)).toString());
			train5.setSeats(getRandomSeats(3));
			trainList.add(train5);
			switch (i)
			{
			case 1: // '\001'
				trainList.remove(5);
				trainList.remove(5);
				break;

			case 2: // '\002'
				trainList.remove(10);
				break;
			}
		}

		return trainList;
	}

	private static Map getRandomSeats(int n)
	{
		List names = new ArrayList();
		List prices = new ArrayList();
		Map map = new HashMap();
		names.add("商务座");
		names.add("特等座");
		names.add("一等座");
		names.add("二等座");
		names.add("高级软卧");
		names.add("软卧");
		names.add("硬卧");
		names.add("软座");
		names.add("硬座");
		names.add("无座");
		prices.add(Double.valueOf(300D));
		prices.add(Double.valueOf(280D));
		prices.add(Double.valueOf(260D));
		prices.add(Double.valueOf(240D));
		prices.add(Double.valueOf(220D));
		prices.add(Double.valueOf(200D));
		prices.add(Double.valueOf(180D));
		prices.add(Double.valueOf(160D));
		prices.add(Double.valueOf(140D));
		prices.add(Double.valueOf(140D));
		Random rd = new Random();
		for (int i = 0; i < n; i++)
		{
			int idx = rd.nextInt(names.size());
			String seatName = (String)names.get(idx);
			Seat seat = new Seat();
			seat.setSeatName(seatName);
			seat.setSeatNum(rd.nextInt(50) + 1);
			seat.setSeatPrice(((Double)prices.get(idx)).doubleValue() + (double)rd.nextInt(20));
			names.remove(idx);
			prices.remove(idx);
			map.put(seatName, seat);
		}

		return map;
	}

	public static List findByDate(List all, String startTrainDate)
	{
		List data = new ArrayList();
		for (int i = 0; i < all.size(); i++)
		{
			Train train = (Train)all.get(i);
			if (train.getStartTrainDate().equals(startTrainDate))
				data.add(train);
		}

		return data;
	}

	public static Train findByDateAndTrainNo(List all, String startTrainDate, String trainNo)
	{
		Train train = null;
		for (int i = 0; i < all.size(); i++)
		{
			Train obj = (Train)all.get(i);
			if (!obj.getStartTrainDate().equals(startTrainDate) || !obj.getTrainNo().equals(trainNo))
				continue;
			train = obj;
			break;
		}

		return train;
	}

	public static List bindStation(List all, String fromStationName, String toStationName)
	{
		for (int i = 0; i < all.size(); i++)
		{
			Train train = (Train)all.get(i);
			switch (i)
			{
			case 0: // '\0'
				train.setStartStationName("北京");
				train.setEndStationName(toStationName);
				train.setFromStationName(fromStationName);
				train.setToStationName(toStationName);
				break;

			case 1: // '\001'
				train.setStartStationName(fromStationName);
				train.setEndStationName("大连");
				train.setFromStationName(fromStationName);
				train.setToStationName(toStationName);
				break;

			case 2: // '\002'
				train.setStartStationName("北京");
				train.setEndStationName("大连");
				train.setFromStationName(fromStationName);
				train.setToStationName(toStationName);
				break;

			default:
				train.setStartStationName(fromStationName);
				train.setEndStationName(toStationName);
				train.setFromStationName(fromStationName);
				train.setToStationName(toStationName);
				break;
			}
		}

		return all;
	}

	public static List updateByTrain(List all, Train train)
	{
		for (int i = 0; i < all.size(); i++)
		{
			Train oldTrain = (Train)all.get(i);
			if (!oldTrain.getTrainNo().equals(train.getTrainNo()) || !oldTrain.getStartTrainDate().equals(train.getStartTrainDate()))
				continue;
			all.set(i, train);
			break;
		}

		return all;
	}
}
