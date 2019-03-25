package com.aowin.util;

public class TimeConvert {
	public static String Convert(String time) {
		String[] t=time.split("-| ");
		int year=Integer.parseInt(t[0]);
		int month=Integer.parseInt(t[1]);
		int day=Integer.parseInt(t[2]);
		return year+"-"+month+"-"+day+" 00:00:00";
	}
/*	public static void main() {
		String sd=TimeConvert.Convert("2018-07-01 00:00:00");
		System.out.println(sd);
	}*/
}
