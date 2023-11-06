package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import exception.IncorrectFormatException;
import utils.Constants;
import utils.Validator;

public class Order {
	private String orderNumber, orderDate;
	private double total;
	private Set<OrderDetail> orderDetailSet;
	
	
	public Order() {
		super();
	}

	public Order(String orderNumber, String orderDate) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
	}



	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) throws IncorrectFormatException {
		if (Validator.isOrderNumber(orderNumber)) {
			this.orderNumber = orderNumber;
		} else {
			throw new IncorrectFormatException(Constants.INCORRECT_ORDER_NUMBER_MESSAGE);
		}
	}

	public String getDate() {
		return orderDate;
	}

	public void setOrderDate(String date) throws ParseException, IncorrectFormatException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyy");
		try {
			date = dateFormat.format(dateFormat.parseObject(date));
			if (Validator.isDate(date)) {
				this.orderDate = date;
			} else {
				throw new IncorrectFormatException(Constants.INCORRECT_DATE_MESSAGE);
			}
		} catch (ParseException e) {
			throw e;
		}
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Set<OrderDetail> getOrderDetailSet() {
		return orderDetailSet;
	}

	public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
		this.orderDetailSet = orderDetailSet;
	}


}
