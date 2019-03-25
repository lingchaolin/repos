package com.effort.jpatest.service;

import org.springframework.data.domain.Page;

import com.effort.jpatest.pojo.Person;

public interface PersonService {

	public void insertPerson(Person person) ;
	public Page<Person> getPersons(int pages,int pagesize);
	public Person getPersonById(Integer id);
}
