package services;

import java.text.ParseException;
import java.util.*;

import entities.*;
import exception.IncorrectFormatException;

public class OrderDetailService {
	List<OrderDetail> orderDetails;
	OrderDetail orderDetail = new OrderDetail(productNumber, amount, price, product);
	List<Order> orders;
	Order order = new Order();
	String productNumber;
	int amount; 
	String price; 
	String choice;
	Scanner sc = new Scanner(System.in);

	public OrderDetailService(List<OrderDetail> orderDetails) {
		super();
		this.orderDetails = orderDetails;
	}
	
	public OrderDetailService() {
		// TODO Auto-generated constructor stub
		super();
	}
    
	
	//create OrderDetail
	public List<OrderDetail> createOrderDetail(Scanner sc) throws IncorrectFormatException, ParseException {

		do {
			System.out.print("Input order detail information! \nChoose product:");
			productNumber = sc.nextLine();
			orderDetail.setProductNumber(productNumber);
			
			ProductService productService = new ProductService();
			
		    double price2 = productService.getProductPrice(productNumber, sc);
		    orderDetail.setPrice(price2);
			

			System.out.print("Enter amount (number): ");
			amount = sc.nextInt();
			orderDetail.setAmount(amount);
			


			orderDetails.add(orderDetail);

			System.out.println("Do you want to continue adding order detail? y/n");
			choice = sc.nextLine();
		} while (choice.equalsIgnoreCase("y"));
		return orderDetails;
	}
	
	
	//find OrderDetail
	public OrderDetail findOrderDetailByOrderNumber(String orderNumber) {
		System.out.println("Enter order number: ");
		orderNumber = sc.nextLine();
	    for (Order order : orders) {
	        if (order.getOrderNumber().equals(orderNumber)) {
	            return orderDetail;
	        }
	    }
	    return null; // Return null if order detail is not found
	}
	
	
	  // display OrderDetail
	   public void displayOrderDetails() {
	        System.out.println("List of Order Details:");
	        
	        for (OrderDetail orderDetail : orderDetails) {
	            System.out.println("Order Number: " + order.getOrderNumber());
	            // Print other details of the order detail
	            System.out.println("Product Number: " + orderDetail.getProductNumber());
	            System.out.println("Amount: " + orderDetail.getAmount());
	            System.out.println("Price: " + orderDetail.getPrice());
	            System.out.println("---------------------------");
	        }
	    }
	   
	   //update OrderDetail
	    public void updateOrderDetailByOrderNumber(String orderNumber, Scanner sc) {
	        List<OrderDetail> foundorderDetails = (List<OrderDetail>) findOrderDetailByOrderNumber(orderNumber);
	        
	        if (foundorderDetails.isEmpty()) {
	            System.out.println("No order details found for the given order number.");
	            return;
	        }else {
	        	System.out.println("Order details found:" + foundorderDetails);}
	        
	        do {
	        		System.out.println("Enter the product number of the order detail to update: ");
		            String productNumber = sc.nextLine();

		            for (OrderDetail orderDetail : foundorderDetails) {
		                if (orderDetail.getProductNumber().equals(productNumber)) {
		                	System.out.println("Enter the new amount: ");
			                int amount = sc.nextInt();
			                orderDetail.setAmount(amount);

			                System.out.println("Enter the new price: ");
			                double price = sc.nextInt();
			                orderDetail.setPrice(price);

			                System.out.println("Order detail updated successfully!");         
		            } else {
		                System.out.println("Order detail with product number " + productNumber + " not found.");}
		                
		                System.out.println("Do you want to continue adding order detail? y/n");
		    			choice = sc.nextLine();
		            }} while (choice.equalsIgnoreCase("y")) ;
	        }
		            
		            //remove OrderDetail
		            public void removeOrderDetailByOrderNumber(String orderNumber) {
		    	        List<OrderDetail> foundorderDetails = (List<OrderDetail>) findOrderDetailByOrderNumber(orderNumber);
		    	        
		    	        if (orderDetails.isEmpty()) {
		    	            System.out.println("No order details found for the given order number.");
		    	            return;
		    	        }else {
		    	        	System.out.println("Order details found:" + foundorderDetails);
		    	        }
		    	        do {
		    	        		System.out.println("Enter the product number of the order detail to remove: ");
		    		            String productNumber = sc.nextLine();
		    		            
		    		            OrderDetail orderDetailToDelete = null;
		    		            for (OrderDetail orderDetail : foundorderDetails) {
		    		                if (orderDetail.getProductNumber().equals(productNumber)) {
		    		                    orderDetailToDelete = orderDetail;
		    		                    break;
		    		                }
		    		            }

		    		            if (orderDetailToDelete != null) {
		    		                System.out.print("Do you want to remove this order detail? (y/n): ");
		    		                choice = sc.nextLine();
		    		                if (choice.equalsIgnoreCase("y")) {
		    		                    foundorderDetails.remove(orderDetailToDelete);
		    		                    System.out.println("Order detail removed successfully.");
		    		                } else {
		    		                    System.out.println("Order detail not removed.");
		    		                }
		    		            } else {
		    		                System.out.println("Order detail not found for the given product number.");
		    		            }
		    		            
		    		            System.out.println("Do you want to continue remove other order detail? y/n");
		    		    			choice = sc.nextLine();
		    		            }while (choice.equalsIgnoreCase("y")) ;  
	        		
		            }}
