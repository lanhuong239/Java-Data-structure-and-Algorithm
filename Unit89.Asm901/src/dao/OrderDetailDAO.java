package dao;

import java.util.List;

import entities.OrderDetail;

public interface OrderDetailDAO {
	void addOrderDetail(OrderDetail orderDetail);
	boolean updateOrderDetail(String productNumber,OrderDetail orderDetail);
	void deleteOrderDetail(String productNumber);
	List<OrderDetail> searchByProductNumber(String productNumber);
}
