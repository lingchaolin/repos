/**
 * 
 */
package com.aowin.testspring.jdbc.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.aowin.testspring.jdbc.pojo.Students;

/**
 * @author TY
 * create date: 2018年8月10日 上午11:20:49
 */
public class StudentDAOImpl extends JdbcDaoSupport implements StudentDAO {

	public StudentDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insertStudent(Students s) {
		boolean result = false;
		String sql = "insert into students(student_name,student_sex,student_birthday) "
				+ "values (?,?,?)";
		int i = super.getJdbcTemplate().update(sql, s.getStudentname(),s.getStudentsex(),s.getStudentbirthday());
		if(i != 0) {
			result = true;
		}
		return result;
	}

}
