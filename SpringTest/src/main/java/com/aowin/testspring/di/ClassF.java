package com.aowin.testspring.di;

import com.aowin.cla.ClassC;
import com.aowin.cla.ClassD;

/**
 * @author TY
 * create date: 2018年8月9日 上午9:31:03
 */
public class ClassF {
	
	private ClassD cd;
	private ClassC cc;

	
	public ClassF() {
		// TODO Auto-generated constructor stub
	}


	public ClassF(ClassD cd, ClassC cc) {
		super();
		this.cd = cd;
		this.cc = cc;
	}


	/**
	 * @return the cd
	 */
	public ClassD getCd() {
		return cd;
	}


	/**
	 * @param cd the cd to set
	 */
	public void setCd(ClassD cd) {
		this.cd = cd;
	}


	/**
	 * @return the cc
	 */
	public ClassC getCc() {
		return cc;
	}


	/**
	 * @param cc the cc to set
	 */
	public void setCc(ClassC cc) {
		this.cc = cc;
	}
	
	
}
