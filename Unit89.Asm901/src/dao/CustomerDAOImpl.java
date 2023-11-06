package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import entities.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	Set<Customer> customers;

	public CustomerDAOImpl() {
		super();
	}

	public CustomerDAOImpl(Set<Customer> customers) {
		super();
		this.customers = customers;
	}

	@Override
	public void addCutomer(Customer customer) {
		customers.add(customer);
	}

	@Override
	public boolean updateCustomer(Customer customer, String phoneNumber) {
		List<Customer> customerResult = this.searchCustomerByPhone(phoneNumber);
		for (Customer customer2 : customerResult) {
			customer2 = customer;
		}
		return true;
	}

	@Override
	public void deleteCustomer(String phoneNumber) {
		for (Customer customer : customers) {
			if (customer.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
				customers.remove(customer);
			}
		}
	}

	@Override
	public List<Customer> searchCustomerByName(String name) {
		List<Customer> customerResult = new ArrayList<>();
		for (Customer customer : customers) {
			if (customer.getPhoneNumber().equalsIgnoreCase(name)) {
				customerResult.add(customer);
			}
		}
		return customerResult;
	}

	@Override
	public List<Customer> searchCustomerByPhone(String phoneNumber) {
		List<Customer> customerResult = new ArrayList<>();
		for (Customer customer : customers) {
			if (customer.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
				customerResult.add(customer);
			}
		}
		return customerResult;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

}
