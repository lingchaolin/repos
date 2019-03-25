package com.aowin.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.aowin.pojo.Person;

public class PersonDaoImpl extends JdbcDaoSupport implements PersonDao {

	@Override
	public boolean insertPerson(Person person) {
		boolean flag=false;
		String sql="insert into Person(id,name,sex,department,salary) values (?,?,?,?,?)";
		int i=super.getJdbcTemplate().update(sql,person.getId(),person.getName(),
				person.getSex(),person.getDepart(),person.getSalary());
		if(i!=0) {
			flag=true;
		}
		return flag;
	}


}
