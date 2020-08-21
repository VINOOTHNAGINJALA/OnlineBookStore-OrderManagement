package com.capgemini.obs.om.service;
import java.util.List;
import com.capgemini.obs.om.entity.Order;
import java.util.Optional;
public interface OrderService
{
	public String updateShippingInfo(Order order);
	
	public List<Order> getOrders();
	   
	public Optional<Order> getOrder(int orderId);
}
