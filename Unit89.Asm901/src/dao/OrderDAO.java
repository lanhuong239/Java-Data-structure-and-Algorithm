package dao;

import java.util.List;

import entities.Order;


public interface OrderDAO {
	void addOrder(Order order);
	boolean updateOrder(String orderNumber,Order order);
	void deleteOrder(String orderNumber);
	List<Order> searchByOrderNumber(String orderNumber);
	List<Order> searchByOrderDate(String orderDate);
}
