package services;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import dao.OrderDaoImpl;
import entities.Order;
import exception.IncorrectFormatException;

public class OrderService {
	Set<Order> orderSet;
	OrderDaoImpl orderDaoImpl;

	public OrderService() {
		super();
	}

	public OrderService(OrderDaoImpl orderDaoImpl) {
		super();
		this.orderSet = new HashSet<>();
		this.orderDaoImpl = orderDaoImpl;
		this.orderDaoImpl.setOrderSet(orderSet);
	}

	public void createOrder(Scanner sc) throws IncorrectFormatException, ParseException {
		String choice;

		do {
			Order order = new Order();
			String orderNumber, date;
			System.out.print("Input order information! \nEnter order number:");
			orderNumber = sc.nextLine();
			order.setOrderNumber(orderNumber);

			System.out.print("Enter date: ");
			date = sc.nextLine();
			order.setOrderDate(date);

			orderDaoImpl.addOrder(order);

			System.out.println("Do you want to continue adding order? y/n");
			choice = sc.nextLine();
		} while (choice.equalsIgnoreCase("y"));
	}

	public void removeOrder(String orderNumber) {
		orderDaoImpl.deleteOrder(orderNumber);
	}

	public boolean updateOrder(String orderNumber, Order order){
		return orderDaoImpl.updateOrder(orderNumber, order);
	}

	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}
}
