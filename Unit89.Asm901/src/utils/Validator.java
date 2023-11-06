package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.Constants;

public class Validator {
	private static Matcher matcher = null;
	private static Pattern pattern = null;

	public static boolean isDate(String date) {
		pattern = Pattern.compile(Constants.DATE_PATTERN);
		matcher = pattern.matcher(date);
		return matcher.matches();
	}

	public static boolean isPhoneNumber(String phoneNumber) {
		pattern = Pattern.compile(Constants.PHONE_PATTERN);
		matcher = pattern.matcher(phoneNumber);
		return matcher.matches();
	}
	
	public static boolean isOrderNumber(String orderNumber) {
		pattern = Pattern.compile(Constants.ORDER_NUMBER_PATTERN);
		matcher = pattern.matcher(orderNumber);
		return matcher.matches();
	}
}
