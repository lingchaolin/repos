/**
 * 
 */
package com.aowin.testspring.jdbc.anntotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.aowin.testspring.jdbc.dao.StudentDAO;
import com.aowin.testspring.jdbc.pojo.Students;

/**
 * @author TY
 * create date: 2018年8月10日 上午11:48:13
 */
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private JdbcTemplate template;


	public StudentDAOImpl() {
		
	}

	@Override
	public boolean insertStudent(Students s) {
		boolean result = false;
		String sql = "insert into students(student_name,student_sex,student_birthday) "
				+ "values (?,?,?)";
		int i = template.update(sql, s.getStudentname(),s.getStudentsex(),s.getStudentbirthday());
		if(i != 0) {
			result = true;
		}
		return result;
	}

}
