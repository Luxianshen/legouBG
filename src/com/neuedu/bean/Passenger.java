// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Passenger.java

package com.neuedu.bean;

import java.io.Serializable;

// Referenced classes of package com.neuedu.bean:
//			Seat

public class Passenger
	implements Serializable
{

	private String id;
	private String name;
	private String idType;
	private String tel;
	private String type;
	private Seat seat;

	public Passenger()
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getIdType()
	{
		return idType;
	}

	public void setIdType(String idType)
	{
		this.idType = idType;
	}

	public String getTel()
	{
		return tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public Seat getSeat()
	{
		return seat;
	}

	public void setSeat(Seat seat)
	{
		this.seat = seat;
	}

	public String toString()
	{
		return (new StringBuilder("Passenger [id=")).append(id).append(", idType=").append(idType).append(", name=").append(name).append(", seat=").append(seat).append(", tel=").append(tel).append(", type=").append(type).append("]").toString();
	}
}
