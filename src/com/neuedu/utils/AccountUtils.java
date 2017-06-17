// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   AccountUtils.java

package com.neuedu.utils;

import com.neuedu.bean.Account;

public class AccountUtils
{

	public AccountUtils()
	{
	}

	public static Account getAccount()
	{
		Account account = new Account();
		account.setId("11010119910511947X");
		account.setIdType("身份证");
		account.setName("冬不拉");
		account.setTel("13812345678");
		account.setUsername("dong");
		account.setPassword("dong");
		account.setType("成人");
		return account;
	}
}
