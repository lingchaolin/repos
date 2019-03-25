package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String currentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	public static String currentMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-01");
		return sdf.format(new Date());	
	}
	public static String nextMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-01");
		Date d=new Date();
		d.setMonth(d.getMonth()+1);
		return sdf.format(d);	
	}
	public static String createDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}

	public static String getNow() {
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(d);

	}
	public static String getNum() {
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sf.format(d);
	}

	public static String StringNowToNum(String now){
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyyMMddHHmmss");

		Date d = null;
		try {
			d = sf1.parse(now);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sf2.format(d);
	}
}
