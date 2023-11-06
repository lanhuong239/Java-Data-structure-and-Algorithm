package entities;

public class OrderDetail {
	//ProductNumber	Amount	Price


	private String productNumber;
	private int amount;
	private double price;
	private Product product;
	
	public OrderDetail(String productNumber, int amount, double price, Product product) {
		super();
		this.productNumber = productNumber;
		this.amount = amount;
		this.price = price;
		this.product = product;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

}
