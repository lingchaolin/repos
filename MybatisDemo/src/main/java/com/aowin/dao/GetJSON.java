package com.aowin.dao;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Spring;

import org.json.JSONObject;

public class GetJSON {

	public GetJSON() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Date now=new Date();
		System.out.println(now);
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(dateFormat.format(now));
	}

}