package entities;

import java.io.Serializable;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	private String productNumber, productName;
	private double unitPrice;
	
	
	public Product() {
		super();
	}
	public Product(String productNumber, String productName, double unitPrice) {
		super();
		this.productNumber = productNumber;
		this.productName = productName;
		this.unitPrice = unitPrice;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
}
