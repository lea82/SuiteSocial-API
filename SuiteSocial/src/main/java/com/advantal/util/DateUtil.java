package com.advantal.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static String convertDateToString(Date date) {
		if (date != null) {
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String strDate = dateFormat.format(date);
			return strDate;
		} else {
			return "";
		}

	}
	
	public static String convertDateToStringWithTime(Date date) {
		if (date != null) {
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			String strDate = dateFormat.format(date);
			return strDate;
		} else {
			return "";
		}

	}

	public static String convertDateToStringExpiry(Integer duration) {
		if (duration != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy hh:mm:ss");
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DAY_OF_MONTH, duration - 1);
			String newDate = sdf.format(c.getTime());
			return newDate;
		} else {
			return "";
		}

	}
	public static String convertTimeStampToDate(long timeStamp) {
		   if(timeStamp!=0L) {
		   	Date currentDate = new Date(timeStamp);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
		String newDate=df.format(currentDate);
		return newDate;
		   }
		   else {
		   	return "";
		   }

		}
}
