package com.robertocosta.devsuperiorspringchapter01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertocosta.devsuperiorspringchapter01.entities.Order;

@Service
public class OrderService {
	
	@Autowired
	private ShippingService shippinService;
	
	public double total(Order order) {
		double shipment = shippinService.shipment(order);
		double discount = order.getBasic() * order.getDiscount()/100.0;
		return order.getBasic() - discount + shipment;
	}
}
