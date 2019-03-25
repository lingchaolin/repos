package com.aowin.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.aowin.anntotation.PersonAnnoDAOImpl;
import com.aowin.dao.PersonDao;
import com.aowin.pojo.Person;

public class PersonTransactionImpl {
	@Autowired
	PersonDao personanoiml;
	public PersonTransactionImpl() {
		// TODO Auto-generated constructor stub
	}
	public void PersonService() {
		Person p1=new Person("уехЩ", 1, "lead", 1234);
		Person p2=new Person("lisi", 1, "lead", 1234);
		personanoiml.insertPerson(p1);
		int i=1/0;
		personanoiml.insertPerson(p2);
	}
}
