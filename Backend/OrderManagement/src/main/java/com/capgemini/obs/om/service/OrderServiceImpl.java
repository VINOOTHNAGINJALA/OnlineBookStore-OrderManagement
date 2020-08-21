package com.capgemini.obs.om.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capgemini.obs.om.dao.OrderDao;
import com.capgemini.obs.om.entity.Order;

@Service
public class OrderServiceImpl implements OrderService
{
	@Autowired
	OrderDao odao;

	public String updateShippingInfo(Order order) 
	{
		odao.save(order);
		return "Updated";
	}

	@Transactional(readOnly=true)
	public List<Order> getOrders()
	{
		return odao.findAll(Sort.by(Sort.Direction.ASC, "orderId"));
	}

	@Transactional(readOnly=true)
	public Optional<Order> getOrder(int orderId)
	{
		return odao.findById(orderId);
	}
}
