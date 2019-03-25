/**
 * 
 */
package com.aowin.testspring.jdbc.dao;

import com.aowin.testspring.jdbc.pojo.Students;

/**
 * @author TY
 * create date: 2018年8月10日 上午11:19:39
 */
public interface StudentDAO {
	
	/**
	 * 添加学生信息
	 * @param s 学生基本信息
	 * @return 是否添加成功
	 */
	public boolean insertStudent(Students s);

}
