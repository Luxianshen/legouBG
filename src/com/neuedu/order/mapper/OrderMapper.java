package com.neuedu.order.mapper;

import java.util.List;

import com.neuedu.order.entity.Order;

public interface OrderMapper {

	public List<Order> getOrder(Integer userID);
	public Order getOrderone(int userID,int proId);
	public void Orderupdate(Order order);
	public void insertOrders(Order order);
}
