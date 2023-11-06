package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import entities.Order;

public class OrderDaoImpl implements OrderDAO {
	Set<Order> orderSet;

	public OrderDaoImpl() {
		super();
	}

	public OrderDaoImpl(Set<Order> orderSet) {
		super();
		this.orderSet = orderSet;
	}

	@Override
	public void addOrder(Order order) {
		orderSet.add(order);
	}

	@Override
	public boolean updateOrder(String orderNumber, Order order) {
		for (Order orderItem : orderSet) {
			if (orderItem.getOrderNumber().equals(orderNumber)) {
				orderItem = order;
				return true;
			}
		}
		return false;
	}

	@Override
	public void deleteOrder(String orderNumber) {
		for (Order order : orderSet) {
			if (order.getOrderNumber().equals(orderNumber)) {
				orderSet.remove(order);
			}
		}
	}

	@Override
	public List<Order> searchByOrderNumber(String orderNumber) {
		List<Order> searchResult = new ArrayList<>();
		for (Order order : orderSet) {
			if (order.getDate().equals(orderNumber)) {
				searchResult.add(order);
			}
		}
		return searchResult;
	}

	@Override
	public List<Order> searchByOrderDate(String orderDate) {
		List<Order> searchResult = new ArrayList<>();
		for (Order order : orderSet) {
			if (order.getDate().equals(orderDate)) {
				searchResult.add(order);
			}
		}
		return searchResult;
	}

	public Set<Order> getOrderSet() {
		return orderSet;
	}

	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}

}
