package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import entities.Product;

public class ProductDaoImpl implements ProductDAO {
	Set<Product> productSet;

	public ProductDaoImpl() {
		super();
	}

	public ProductDaoImpl(Set<Product> productSet) {
		super();
		this.productSet = productSet;
	}

	@Override
	public void addProduct(Product product) {
		productSet.add(product);
	}

	@Override
	public boolean updateProduct(String productNumber, Product product) {
		for (Product productItem : productSet) {
			if (productItem.getProductNumber().equals(productNumber)) {
				productItem = product;
				return true;
			}
		}
		return false;
	}

	@Override
	public void deleteProduct(String productNumber) {
		for (Product product : productSet) {
			if (product.getProductNumber().equals(productNumber)) {
				productSet.remove(product);
			}
		}
	}

	@Override
	public List<Product> searchByProductNumber(String productNumber) {
		List<Product> searchResult = new ArrayList<>();
		for (Product product : productSet) {
			if (product.getProductNumber().equals(productNumber)) {
				searchResult.add(product);
			}
		}
		return searchResult;
	}

	@Override
	public List<Product> searchByProductName(String productName) {
		List<Product> searchResult = new ArrayList<>();
		for (Product product : productSet) {
			if (product.getProductNumber().equals(productName)) {
				searchResult.add(product);
			}
		}
		return searchResult;
	}

	public Set<Product> getProductSet() {
		return productSet;
	}

	public void setProductSet(Set<Product> productSet) {
		this.productSet = productSet;
	}

}
