/**
 * 
 */
package com.mastertutorial.mvc.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author Yashwanth
 *
 */
public class DateFormatter {

	public static LocalDate parseDate(String dateFormat,String value) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		formatter = formatter.withLocale(Locale.getDefault());
		return LocalDate.parse(value,formatter);
		
	}
}
