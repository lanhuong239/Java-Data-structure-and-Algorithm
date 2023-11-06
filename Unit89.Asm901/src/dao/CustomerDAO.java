package dao;

import java.util.List;

import entities.Customer;

public interface CustomerDAO {
	void addCutomer(Customer customer);
	boolean updateCustomer(Customer customer, String phoneNumber);
	void deleteCustomer(String phoneNumber);
	List<Customer> searchCustomerByName(String name);
	List<Customer> searchCustomerByPhone(String phoneNumber);
}