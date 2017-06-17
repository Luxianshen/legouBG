// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Train.java

package com.neuedu.bean;

import java.io.Serializable;
import java.util.Map;

public class Train
	implements Serializable
{

	private String trainNo;
	private String startStationName;
	private String endStationName;
	private String fromStationName;
	private String toStationName;
	private String startTime;
	private String arriveTime;
	private int dayDifference;
	private String durationTime;
	private String startTrainDate;
	private Map seats;

	public Train()
	{
	}

	public String getTrainNo()
	{
		return trainNo;
	}

	public void setTrainNo(String trainNo)
	{
		this.trainNo = trainNo;
	}

	public String getStartStationName()
	{
		return startStationName;
	}

	public void setStartStationName(String startStationName)
	{
		this.startStationName = startStationName;
	}

	public String getEndStationName()
	{
		return endStationName;
	}

	public void setEndStationName(String endStationName)
	{
		this.endStationName = endStationName;
	}

	public String getFromStationName()
	{
		return fromStationName;
	}

	public void setFromStationName(String fromStationName)
	{
		this.fromStationName = fromStationName;
	}

	public String getToStationName()
	{
		return toStationName;
	}

	public void setToStationName(String toStationName)
	{
		this.toStationName = toStationName;
	}

	public String getStartTime()
	{
		return startTime;
	}

	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}

	public String getArriveTime()
	{
		return arriveTime;
	}

	public void setArriveTime(String arriveTime)
	{
		this.arriveTime = arriveTime;
	}

	public int getDayDifference()
	{
		return dayDifference;
	}

	public void setDayDifference(int dayDifference)
	{
		this.dayDifference = dayDifference;
	}

	public String getDurationTime()
	{
		return durationTime;
	}

	public void setDurationTime(String durationTime)
	{
		this.durationTime = durationTime;
	}

	public String getStartTrainDate()
	{
		return startTrainDate;
	}

	public void setStartTrainDate(String startTrainDate)
	{
		this.startTrainDate = startTrainDate;
	}

	public Map getSeats()
	{
		return seats;
	}

	public void setSeats(Map seats)
	{
		this.seats = seats;
	}

	public String toString()
	{
		return (new StringBuilder("Train [arriveTime=")).append(arriveTime).append(", dayDifference=").append(dayDifference).append(", durationTime=").append(durationTime).append(", endStationName=").append(endStationName).append(", fromStationName=").append(fromStationName).append(", seats=").append(seats).append(", startStationName=").append(startStationName).append(", startTime=").append(startTime).append(", startTrainDate=").append(startTrainDate).append(", toStationName=").append(toStationName).append(", trainNo=").append(trainNo).append("]").toString();
	}
}
