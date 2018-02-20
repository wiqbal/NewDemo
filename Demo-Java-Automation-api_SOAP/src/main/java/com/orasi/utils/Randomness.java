package com.orasi.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class Randomness {

	public static String generateMessageId() {
		return randomAlphaNumeric(8) + "-" + randomAlphaNumeric(6) + "-"
				+ randomAlphaNumeric(6) + "-" + randomAlphaNumeric(6) + "-"
				+ randomAlphaNumeric(10);
	}

	public static String generateCurrentDatetime() {
		String repDate = "";
		DateFormat dfms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); // for display with milliseconds
		Calendar cal = Calendar.getInstance();
		repDate = dfms.format(cal.getTime());

		return repDate;
	}

	public static String generateCurrentXMLDatetime() {
		String adDate = "1963-01-01";
		DateFormat dfms = new SimpleDateFormat("yyyy-MM-dd"); // XML date time
		DateFormat dfmst = new SimpleDateFormat("HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String Date = dfms.format(cal.getTime());
		String time = dfmst.format(cal.getTime());
		adDate = Date + "T" + time;

		return adDate;
	}

	public static String generateCurrentXMLDatetime(int daysOut) {
		String adDate = "1963-01-01";
		DateFormat dfms = new SimpleDateFormat("yyyy-MM-dd"); // XML date time
		DateFormat dfmst = new SimpleDateFormat("HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, daysOut);
		String Date = dfms.format(cal.getTime());
		String time = dfmst.format(cal.getTime());
		adDate = Date + "T" + time;

		return adDate;
	}
	
	
	public static String generateCurrentXMLDate() {
		DateFormat dfms = new SimpleDateFormat("yyyy-MM-dd"); // XML date time
		Calendar cal = Calendar.getInstance();
		String Date = dfms.format(cal.getTime());

		return Date;
	}

	public static String generateCurrentXMLDate(int daysOut) {
		DateFormat dfms = new SimpleDateFormat("yyyy-MM-dd"); // XML date time
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, daysOut);
		String Date = dfms.format(cal.getTime());

		return Date;
	}
	public static String randomNumber(int length) {
		new RandomStringUtils();
		return RandomStringUtils.randomNumeric(length);
	}
	
	public static int randomNumberBetween(int min, int max) {		
		return new Random().nextInt((max - min) + 1) + min;
	}

	public static String randomString(int length) {
		new RandomStringUtils();
		return RandomStringUtils.randomAlphabetic(length);
	}

	public static String randomAlphaNumeric(int length) {
		new RandomStringUtils();
		return RandomStringUtils.randomAlphanumeric(length);
	}

	public static Object randomizeArray(Object[] array){
		int index = new Random().nextInt(array.length);
		return array[index];
	}
	
	public static Date randomDate(){
	     
	     int month = new Random().nextInt(Calendar.DECEMBER) + Calendar.JANUARY;;
	     int year = Randomness.randomNumberBetween(1940, 2016);
	     int day  = new Random().nextInt(30)+1;
	 
	       GregorianCalendar calendar = new GregorianCalendar(year, month, day);
	    return calendar.getTime();
	}

}
