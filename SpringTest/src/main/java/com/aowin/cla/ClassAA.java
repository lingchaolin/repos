package com.aowin.cla;

public class ClassAA implements InterfaceOne{
	private String AAName;
	private int AAAge;
	public ClassAA(String aAName, int aAAge) {
		super();
		AAName = aAName;
		AAAge = aAAge;
	}
	public ClassAA() {
		AAName = "test";
		AAAge = 123;
	}
	/**
	 * @return the aAName
	 */
	public String getAAName() {
		return AAName;
	}
	/**
	 * @param aAName the aAName to set
	 */
	public void setAAName(String aAName) {
		AAName = aAName;
	}
	/**
	 * @return the aAAge
	 */
	public int getAAAge() {
		return AAAge;
	}
	/**
	 * @param aAAge the aAAge to set
	 */
	public void setAAAge(int aAAge) {
		AAAge = aAAge;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassAA [AAName=" + AAName + ", AAAge=" + AAAge + "]";
	}
	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		
	}
	
}
