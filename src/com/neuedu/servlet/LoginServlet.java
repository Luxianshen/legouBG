// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LoginServlet.java

package com.neuedu.servlet;

import com.neuedu.bean.*;
import com.neuedu.utils.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

	public LoginServlet() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession se = request.getSession();
		if (se.getAttribute("account") == null) {
			List trainList = TrainListUtils.getTrainList();
			se.setAttribute("account", AccountUtils.getAccount());
			se.setAttribute("passengerList", PassengerUtils.getPassengerList());
			se.setAttribute("trainList", trainList);
			se.setAttribute("orderId", Integer.valueOf(10000));
			List orderList = new ArrayList();
			Train train1 = (Train) trainList.get(0);
			train1.setFromStationName("北京");
			train1.setToStationName("大连");
			Map tmp1 = train1.getSeats();
			Seat seat1 = null;
			Iterator iterator = tmp1.keySet().iterator();
			if (iterator.hasNext()) {
				String key = (String) iterator.next();
				seat1 = (Seat) tmp1.get(key);
			}
			List passengers1 = PassengerUtils.getPassengerList();
			int orderId1 = ((Integer) se.getAttribute("orderId")).intValue();
			se.setAttribute("orderId", Integer.valueOf(orderId1 + 1));
			Order order1 = OrderUtils.getOrder(train1, seat1, passengers1,
					orderId1);
			orderList.add(order1);
			Train train2 = (Train) trainList.get(1);
			train2.setFromStationName("沈阳");
			train2.setToStationName("大连");
			Map tmp2 = train2.getSeats();
			Seat seat2 = null;
			Iterator iterator1 = tmp2.keySet().iterator();
			if (iterator1.hasNext()) {
				String key = (String) iterator1.next();
				seat2 = (Seat) tmp2.get(key);
			}
			List passengers2 = PassengerUtils.getPassengerList();
			passengers2.remove(0);
			int orderId2 = ((Integer) se.getAttribute("orderId")).intValue();
			se.setAttribute("orderId", Integer.valueOf(orderId2 + 1));
			Order order2 = OrderUtils.getOrder(train2, seat2, passengers2,
					orderId2);
			order2.setStatus(1);
			orderList.add(order2);
			Train train3 = (Train) trainList.get(0);
			train3.setFromStationName("沈阳");
			train3.setToStationName("大连");
			Map tmp3 = train3.getSeats();
			Seat seat3 = null;
			Iterator iterator2 = tmp3.keySet().iterator();
			if (iterator2.hasNext()) {
				String key = (String) iterator2.next();
				seat3 = (Seat) tmp3.get(key);
			}
			List passengers3 = new ArrayList();
			int orderId3 = ((Integer) se.getAttribute("orderId")).intValue();
			se.setAttribute("orderId", Integer.valueOf(orderId3 + 1));
			Order order3 = OrderUtils.getOrder(train3, seat3, passengers3,
					orderId3);
			order3.setStatus(2);
			orderList.add(order3);
			se.setAttribute("orderList", orderList);
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String result = "<result>0</result>";
		Account account = (Account) se.getAttribute("account");
		if (username != null && password != null
				&& username.equals(account.getUsername())
				&& password.equals(Md5Utils.MD5(account.getPassword()))) {
			se.setAttribute("status", Integer.valueOf(1));
			result = "<result>1</result>";
		}
		response.setContentType("text/xml; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.print("<data>");
		out.print(result);
		out.print("</data>");
		out.close();
	}
}
