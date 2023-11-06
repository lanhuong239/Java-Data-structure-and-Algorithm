package services;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

import dao.CustomerDAOImpl;
import entities.Customer;
import entities.Order;
import exception.IncorrectFormatException;
import utils.Constants;

public class CustomerService {
	private Set<Customer> customerSet;
	private CustomerDAOImpl customerDaoImplement;

	public CustomerService() {
		super();
	}

	public CustomerService(CustomerDAOImpl customerDaoImplement) {
		super();
		this.customerSet = new HashSet<>();
		this.customerDaoImplement = customerDaoImplement;
		this.customerDaoImplement.setCustomers(customerSet);
	}

	public void createCustomer(Scanner sc) throws IncorrectFormatException {
		String choice;

		do {
			Customer customer = new Customer();
			String name, phoneNumber, address;
			System.out.print("Input customer information! \nEnter his/her name:");
			name = sc.nextLine();
			customer.setName(name);

			System.out.print("Enter phone number: ");
			phoneNumber = sc.nextLine();
			customer.setPhoneNumber(phoneNumber);

			System.out.print("Enter address: ");
			address = sc.nextLine();
			customer.setAddress(address);

			customerDaoImplement.addCutomer(customer);

			System.out.println("Do you want to continue adding customer? y/n");
			choice = sc.nextLine();
			System.out.println(customerDaoImplement);
		} while (choice.equalsIgnoreCase("y"));
	}
	
	public Set<Customer> readCustomerFromFile(String path) {
		Customer customer;
		try (ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(path))) {
			while (true) {
				try {
					customer = (Customer) objInput.readObject();
					customerSet.add(customer);
				} catch (EOFException e) {
					break;
				}

			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return customerSet;
	}

	public void save(Set<Customer> customerSet) throws Exception {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new FileOutputStream(Constants.CUSTOMER_FILE_PATH))) {
			objectOutputStream.writeObject(customerSet);
		}
	}

	public Set<Customer> findAll() throws Exception {
		Set<Customer> customers = new HashSet<>();
		Customer customer = null;
		try (ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream(Constants.CUSTOMER_FILE_PATH))) {
			while ((customer = (Customer) objInputStream.readObject()) != null) {
				customers.add(customer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return customers;
	}

	public void display(List<Customer> list) {
		System.out.println("Customer name \t PhoneNumber \t Address \t OrderList");
		for (Customer customer : list) {
			System.out.println(customer.getName() + "\t" + customer.getPhoneNumber() + "\t" + customer.getAddress()
					+ "\t" + customer.getListOfOder());
		}
	}

	public List<Order> searchOrder(String phone) {
		List<Order> orders = null;
		for (Customer customer : customerSet) {
			if (customer.getPhoneNumber().equals(phone)) {
				orders = customer.getListOfOder();
			}
		}
		return orders;
	}

	public List<Customer> searchCustomerByPhone(String phone) {
		List<Customer> customerSearchResult = customerDaoImplement.searchCustomerByPhone(phone);
		return customerSearchResult;
	}

	public void removeCustomer(String phone) throws Exception {
		Set<Customer> cusList = findAll();
		for (Customer customer : cusList) {
			if (customer.getPhoneNumber().equals(phone)) {
				cusList.remove(customer);
			}
		}

		try (ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(Constants.CUSTOMER_FILE_PATH))) {
			objOutput.writeObject(cusList);
		}

	}

	public Set<Customer> getCustomerSet() {
		return customerSet;
	}

	public void setCustomerSet(Set<Customer> customerSet) {
		this.customerSet = customerSet;
	}


}
