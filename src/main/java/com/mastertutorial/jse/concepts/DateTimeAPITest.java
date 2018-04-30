/**
 * 
 */
package com.mastertutorial.jse.concepts;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Yashwanth
 *
 */
public class DateTimeAPITest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getLocalDateImpl();
		getLocalTimeImpl();
		getLocalDateTimeImpl();
		getInstant();
		LocalDate localDate = LocalDate.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		printParsedDate(localDate,localDateTime);
	}

	private static void printParsedDate(LocalDate localDate,LocalDateTime localDateTime) {
		System.out.println("--------------------------- Start of DateTimeAPITest :: printParsedDate ----------------");
		Instant now = Instant.now();
		System.out.println("Local Date ="+localDate +"\n Local Date Time ="+localDateTime +" Instant ="+now);
		System.out.println(localDate.format(DateTimeFormatter.ofPattern("d::MM::uuuu"))+
				"\n"+localDate.format(DateTimeFormatter.BASIC_ISO_DATE)+
				"\n Date Time ="+localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE)
				+"\n Date Time Format ="+localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-uuuu HH:mm:ss"))
				+"\n ");
		
		LocalDateTime local = LocalDateTime.parse("29-04-2018 23:08:12",DateTimeFormatter.ofPattern("dd-MM-uuuu HH:mm:ss"));
		
		System.out.println("Parsed Local ="+local);
		Instant dateInstant = new Date().toInstant();
		
		LocalDateTime date = LocalDateTime.ofInstant(dateInstant, ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
		System.out.println("Date :: "+date);
		
		Instant calInstant =  Calendar.getInstance().toInstant();
		ZoneId zone = TimeZone.getDefault().toZoneId();
		System.out.println("Cal Instant ="+calInstant +" Zone Id ="+zone);
		
		System.out.println("--------------------------- End of DateTimeAPITest :: printParsedDate ----------------");
		
	}

	private static void getInstant() {
		System.out.println("--------------------------- Start of DateTimeAPITest :: getInstant ----------------");
		
		Instant timestamp = Instant.now();
		System.out.println("Current TimeStamp ="+timestamp);
		
		Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
		System.out.println("Specific Time="+specificTime);
		
		Duration thirtyDay = Duration.ofDays(30);
		System.out.println("Thirty Day Duration = "+thirtyDay);
		
		thirtyDay = Duration.ofMinutes(100000);
		System.out.println("Of Minutes :: "+thirtyDay);
		
		LocalDate localDate = LocalDate.now();
		LocalDate lastDay = localDate.with(TemporalAdjusters.lastDayOfYear());
		
		Period period = localDate.until(lastDay);
		
		System.out.println(" Last Day :: "+lastDay +" Period format = "+period +" Months Remaining = "+period.getMonths());
		
		System.out.println("--------------------------- End of DateTimeAPITest :: getInstant ----------------");
		
		
		
	}

	private static void getLocalDateTimeImpl() {
		System.out.println("--------------------------- Start of DateTimeAPITest :: getLocalDateTimeImpl ----------------");
		
		LocalDateTime today = LocalDateTime.now();
		System.out.println("Today date Time ="+today);
		
		today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("Today Time ="+today);
		
		LocalDateTime specificDateT = LocalDateTime.of(2018, Month.JANUARY,1,10,10,30);
		System.out.println("Specific Date Time ="+specificDateT);
		
			
		System.out.println("--------------------------- End of DateTimeAPITest   :: getLocalDateTimeImpl ----------------");
		
	}

	private static void getLocalTimeImpl() {
		
		System.out.println("--------------------------- Start of DateTimeAPITest :: getLocalTimeImpl ----------------");
		
		LocalTime time = LocalTime.now();
		System.out.println("current Time :: "+time);
		
		LocalTime specificTime = LocalTime.of(12, 23);
		System.out.println("Time 12:23="+specificTime);
		
		LocalTime specific = LocalTime.of(12, 23, 34, 456);
		System.out.println(" specific Time ="+specific);
		
		LocalTime specific1 = LocalTime.of(12, 23,34);
		System.out.println(" specific Time #1 ="+specific1);
		
		LocalTime estTime = LocalTime.now(ZoneId.of("America/New_York"));
		System.out.println(" EST Time :: "+estTime);
		
		LocalTime specific2nd = LocalTime.ofSecondOfDay(1000);
		System.out.println(" 10000 th second time ="+specific2nd);
		

		System.out.println("--------------------------- End of DateTimeAPITest :: getLocalTimeImpl-------------------");
	}

	/**
	 * 
	 */
	public static void getLocalDateImpl() {


		System.out.println("--------------------------- Start of DateTimeAPITest :: getLocalDateImpl----------------");
		
		LocalDate today =LocalDate.now();
		System.out.println("Current Date ::  "+today);
		
		LocalDate firstDay = LocalDate.of(2018, 01, 01);
		System.out.println("First Day of the year ::"+firstDay);
		
		//LocalDate istTime = LocalDate.now(ZoneId.of("CST"));
		//System.out.println(" IST Time :: "+istTime);
		
		LocalDate estTime = LocalDate.now(ZoneId.of("America/New_York"));
		System.out.println(" EST Time :: "+estTime);
		
		LocalDate localBase = LocalDate.ofEpochDay(365);
		System.out.println(" Local Time from Base ::"+localBase);
		
		LocalDate hundredDay2018 = LocalDate.ofYearDay(2018,100);
		System.out.println("Hundredth day of 2018 ::"+hundredDay2018);
		

		System.out.println("---------------------------- End of DateTimeAPITest :: getLocalDateImpl----------------- ");
	}

}
