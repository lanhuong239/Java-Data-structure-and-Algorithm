package utils;

public class Constants {
	public static final String CUSTOMER_FILE_PATH = "customer.dat";
	public static final String PRODUCT_FILE_PATH = "product.dat";
	
	public static final String INCORRECT_DATE_MESSAGE = "Date format is incorrect!";
	public static final String INCORRECT_PHONE_MESSAGE = "Phone format is incorrect!";
	public static final String INCORRECT_ORDER_NUMBER_MESSAGE = "Order number has 10 digits!";
	
	public static final String DATE_PATTERN = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";
	public static final String PHONE_PATTERN = "^\\d{10,}$"; //^[1-9]\\d{2}-\\d{3}-\\d{4}$
	public static final String ORDER_NUMBER_PATTERN = "^\\d{10,}$";
}