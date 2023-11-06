package dao;

import java.util.List;

import entities.Product;

public interface ProductDAO {
	void addProduct(Product product);
	boolean updateProduct(String productNumber, Product product);
	void deleteProduct(String productNumber);
	List<Product> searchByProductNumber(String productNumber);
	List<Product> searchByProductName(String productName);
}