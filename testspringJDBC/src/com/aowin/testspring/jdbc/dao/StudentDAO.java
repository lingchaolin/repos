/**
 * 
 */
package com.aowin.testspring.jdbc.dao;

import com.aowin.testspring.jdbc.pojo.Students;

/**
 * @author TY
 * create date: 2018��8��10�� ����11:19:39
 */
public interface StudentDAO {
	
	/**
	 * ���ѧ����Ϣ
	 * @param s ѧ��������Ϣ
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean insertStudent(Students s);

}
