// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Md5Utils.java

package com.neuedu.utils;

import java.io.PrintStream;
import java.security.MessageDigest;

public class Md5Utils
{

	public Md5Utils()
	{
	}

	public static final String MD5(String s)
	{
		char hexDigits[] = {
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
			'a', 'b', 'c', 'd', 'e', 'f'
		};
		try
		{
			byte btInput[] = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte md[] = mdInst.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++)
			{
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}

			return new String(str);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String args[])
	{
		System.out.println(MD5("dong"));
	}
}
