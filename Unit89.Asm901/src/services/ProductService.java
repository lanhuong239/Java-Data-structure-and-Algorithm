package services;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import dao.ProductDaoImpl;
import entities.Product;
import utils.Constants;

public class ProductService {
	Set<Product> productSet;
	ProductDaoImpl productDaoImpl;

	public ProductService() {
		super();
	}

	public ProductService(ProductDaoImpl productDaoImpl) {
		super();
		this.productSet = new HashSet<>();
		this.productDaoImpl = productDaoImpl;
		this.productDaoImpl.setProductSet(productSet);
	}

	public void createProduct(Scanner sc) {
		String choice;

		do {
			Product product = new Product();
			String productNumber, productName;
			double unitPrice;
			System.out.println("---Create product---\n Enter product number: ");
			productNumber = sc.nextLine();
			product.setProductNumber(productNumber);
			System.out.println("Enter product name: ");
			productName = sc.nextLine();
			product.setProductName(productName);
			System.out.println("Enter unit price: ");
			unitPrice = Double.parseDouble(sc.nextLine());
			product.setUnitPrice(unitPrice);
			productDaoImpl.addProduct(product);

			System.out.println("Do you want to continue adding product? y/n");
			choice = sc.nextLine();
		} while (choice.equalsIgnoreCase("y"));
	}

	public void removeProduct(String productNumber) {
		for (Product product : productSet) {
			if (product.getProductNumber().equals(productNumber)) {
				productSet.remove(product);
			}
		}
	}

	public void updateProduct(String productNumber, Product product) {
		for (Product productItem : productSet) {
			if (productItem.getProductNumber().equals(productNumber)) {
				productItem = product;
			}
		}
	}

	public void displayProduct() {
		System.out.println(productSet);
	}

	public List<Product> findByProductName(String productName) {
		List<Product> result = new ArrayList<>();
		result = productDaoImpl.searchByProductName(productName);
		return result;
	}

	public Set<Product> readProductFromFile() {
		Product product;
		try (ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(Constants.PRODUCT_FILE_PATH))) {
			while (true) {
				try {
					product = (Product) objInput.readObject();
					productSet.add(product);
				} catch (EOFException e) {
					break;
				}

			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return productSet;
	}
	
	public void writeProductToFile(Set<Product> productSet) {
		try (ObjectOutputStream objInput = new ObjectOutputStream(new FileOutputStream(Constants.PRODUCT_FILE_PATH))) {
			objInput.writeObject(productSet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
