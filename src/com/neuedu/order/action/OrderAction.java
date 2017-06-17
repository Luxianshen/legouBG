package com.neuedu.order.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.neuedu.order.entity.Order;
import com.neuedu.order.mapper.OrderMapper;

public class OrderAction {

	private static final long serialVersionUID = -5965885617410849125L;
	
	@Autowired
	private OrderMapper orderMapper;

	private List<Order> listorder;
	private Order order;

	public String findorder() throws IOException {

		// 设置http相关协议 接收相关数据 并返回Json格式的数据
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String action = request.getParameter("action");
		String userid = request.getParameter("userID");
		String proid = request.getParameter("proId");
		String data=request.getParameter("order");
		Gson gson=new Gson();
		Order order=gson.fromJson(data, Order.class);
		// 检验
		HttpSession se = request.getSession();
		String result="1";

		if(action!=null){
			if (action.equals("orderfind")&&userid!=null) {
				System.out.println("订单");
				Integer userID=Integer.parseInt(userid);
				listorder = orderMapper.getOrder(userID);
			}else if(action.equals("orderdel")&&userid!=null){
				//先查找有没有
				Integer userID=Integer.parseInt(userid);
				Integer proId=Integer.parseInt(proid);
				order = orderMapper.getOrderone(userID,proId);
				if(order!=null){
					order.setOrderIsDel("0");
					orderMapper.Orderupdate(order);
					 result="1";
				}else{
					 result="0";
				}
			}else if(action.equals("ordernew")&&order!=null){
				//先查找
				Integer userID=order.getUserID();
				Integer proId=order.getProId();
				Order test=new Order();
				test = orderMapper.getOrderone(userID,proId);
				if(test!=null){
					test.setOrderNum(test.getOrderNum()+1);
					orderMapper.Orderupdate(test);
					result="1";
				}else{
				
					 orderMapper.insertOrders(order);
					 result="1";
				}
			}
			else{
				listorder = null;
				result="-1";
			}
		} else {
			listorder = null;
			result="-1";
		}
		// 打包数据以json格式送回去
		//Gson gson = (new GsonBuilder()).create();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(listorder!=null&&result=="1"){
		out.print(gson.toJson(listorder));
		}else if(result=="1"||result=="0"){
			out.print(gson.toJson(result));
		}
		else{
			result="查无信息";
			out.print(gson.toJson(result));
			System.out.println(gson.toJson(result));
		}
		
		out.close();
		System.out.println(gson.toJson(listorder));
		

		return null;
	}
	
	

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
