package com.aowin.dao;

import org.json.JSONException;
import org.json.JSONObject;

public class GiveJSONObject {

	public GiveJSONObject() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public JSONObject giveMessage() {
		JSONObject jsonObject=new JSONObject();
		try {
			jsonObject.put("123", System.currentTimeMillis());
			Dog dog=new Dog("tom");
			jsonObject.put("dog", dog);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}
class Dog{
	private String name;
	public int age;
	void test() {
		
	}
	public Dog(String name){
		this.name=name;
	}
}
