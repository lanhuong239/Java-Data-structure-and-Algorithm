package main;

import java.text.ParseException;
import java.util.*;
import entities.*;
import exception.IncorrectFormatException;
import services.*;
import utils.Constants;
import dao.*;

public class Test {
	public static void main(String[] args) throws IncorrectFormatException {
		CustomerDAOImpl customerDaoImpl = new CustomerDAOImpl();
		CustomerService customerService = new CustomerService(customerDaoImpl);
		customerService.readCustomerFromFile(Constants.CUSTOMER_FILE_PATH);
		
		Scanner sc = new Scanner(System.in);
		customerService.createCustomer(sc);
		
	}
}
