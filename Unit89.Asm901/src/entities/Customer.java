package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import exception.IncorrectFormatException;
import utils.Constants;
import utils.Validator;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name, phoneNumber, address;
	private List<Order> listOfOder;
	
	public Customer() {
		super();
	}

	public Customer(String name, String phoneNumber, String address, List<Order> listOfOder) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.listOfOder = listOfOder;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) throws IncorrectFormatException{
		if (Validator.isPhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new IncorrectFormatException(Constants.INCORRECT_PHONE_MESSAGE);
		}
		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order> getListOfOder() {
		return listOfOder;
	}

	public void setListOfOder(List<Order> listOfOder) {
		this.listOfOder = listOfOder;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(name, other.name) && Objects.equals(phoneNumber, other.phoneNumber);
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + ", listOfOder="
				+ listOfOder + "]";
	}
	
}
