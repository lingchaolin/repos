package com.aowin.anntotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.aowin.dao.PersonDao;
import com.aowin.pojo.Person;

public class PersonAnnoDAOImpl implements PersonDao{
	@Autowired
	private JdbcTemplate template;
	public PersonAnnoDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insertPerson(Person person) {
		boolean flag=false;
		String sql="insert into Person(id,name,sex,department,salary) values (?,?,?,?,?)";
		int i=template.update(sql,person.getId(),person.getName(),
				person.getSex(),person.getDepart(),person.getSalary());
		if(i!=0) {
			flag=true;
		}
		return flag;
	}


}
