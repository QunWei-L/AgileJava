package com.sends.util;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	
	private DateUtil(){}

	public static Date createDate(int year, int month, int date) {

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.clear();

		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DATE, date);

		return calendar.getTime();

	}

}
