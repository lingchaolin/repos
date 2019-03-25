/**
 * 
 */
package com.aowin.testspring.jdbc.pojo;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author TY
 * create date: 2018年8月10日 上午11:16:51
 */
public class Students implements Serializable {
	
	private Integer studentid;
	private String studentname;
	private String studentsex;
	private Date studentbirthday;

	/**
	 * 
	 */
	public Students() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the studentid
	 */
	public Integer getStudentid() {
		return studentid;
	}

	/**
	 * @param studentid the studentid to set
	 */
	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}

	/**
	 * @return the studentname
	 */
	public String getStudentname() {
		return studentname;
	}

	/**
	 * @param studentname the studentname to set
	 */
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	/**
	 * @return the studentsex
	 */
	public String getStudentsex() {
		return studentsex;
	}

	/**
	 * @param studentsex the studentsex to set
	 */
	public void setStudentsex(String studentsex) {
		this.studentsex = studentsex;
	}

	/**
	 * @return the studentbirthday
	 */
	public Date getStudentbirthday() {
		return studentbirthday;
	}

	/**
	 * @param studentbirthday the studentbirthday to set
	 */
	public void setStudentbirthday(Date studentbirthday) {
		this.studentbirthday = studentbirthday;
	}

	@Override
	public String toString() {
		return "Students [studentid=" + studentid + ", studentname=" + studentname + ", studentsex=" + studentsex
				+ ", studentbirthday=" + studentbirthday + "]";
	}	
	
}
