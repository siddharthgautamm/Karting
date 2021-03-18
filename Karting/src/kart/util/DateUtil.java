package kart.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public Date getDate(String s)
	{
		Date date=null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		try {
			
			date= dateFormat.parse(s);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
