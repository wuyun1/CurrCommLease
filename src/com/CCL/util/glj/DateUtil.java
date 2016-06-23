package com.CCL.util.glj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static String formatDate(Date time)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    return dateFormat.format(time);
	}
	
	public static String formatDate(Object time)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    return dateFormat.format(time);
	}
	
	public static String formatHMDate(Date time)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:SS");
	    return dateFormat.format(time);
	}
	
	public static Date paseDate(String time)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
	    try {
			date = dateFormat.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return date;
	}

	public static String paseDate(Date time) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
	    return dateFormat.format(time);		
	}

}
