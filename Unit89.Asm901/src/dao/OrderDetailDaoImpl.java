package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import entities.OrderDetail;

public class OrderDetailDaoImpl implements OrderDetailDAO {
	Set<OrderDetail> orderDetailSet;

	public OrderDetailDaoImpl() {
		super();
	}

	public OrderDetailDaoImpl(Set<OrderDetail> orderDetailSet) {
		super();
		this.orderDetailSet = orderDetailSet;
	}

	@Override
	public void addOrderDetail(OrderDetail orderDetail) {
		orderDetailSet.add(orderDetail);
	}

	@Override
	public boolean updateOrderDetail(String productNumber, OrderDetail orderDetail) {
		for (OrderDetail orderDetailItem : orderDetailSet) {
			if (orderDetailItem.getProductNumber().equals(productNumber)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void deleteOrderDetail(String productNumber) {
		for (OrderDetail orderDetail : orderDetailSet) {
			if (orderDetail.getProductNumber().equals(productNumber)) {
				orderDetailSet.remove(orderDetail);
			}
		}
	}

	@Override
	public List<OrderDetail> searchByProductNumber(String productNumber) {
		List<OrderDetail> searchResult = new ArrayList<>();
		for (OrderDetail orderDetailItem : orderDetailSet) {
			if (orderDetailItem.getProductNumber().equals(productNumber)) {
				searchResult.add(orderDetailItem);
			}

		}
		return searchResult;
	}

	public Set<OrderDetail> getOrderDetailSet() {
		return orderDetailSet;
	}

	public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
		this.orderDetailSet = orderDetailSet;
	}

}
