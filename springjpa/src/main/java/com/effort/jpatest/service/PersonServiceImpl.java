package com.effort.jpatest.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.effort.jpatest.pojo.Person;
import com.effort.jpatest.respository.PersonRepository;


@Service
public class PersonServiceImpl implements PersonService {
	private Log log=LogFactory.getLog(PersonServiceImpl.class);
	public PersonServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private PersonRepository pr;

	@Override
	@Transactional
	public void insertPerson(Person person) {
		log.info("调用业务逻辑方法：insertPerson");
		System.out.println("person:"+person);
		pr.save(person);		
	}
	@Override
	@Transactional(readOnly=true)
	public Page<Person> getPersons(int pages, int pagesize) {
		log.info("调用业务逻辑方法：getPersons");
		return pr.findAll(PageRequest.of(pages-1, pagesize));
	}
	@Override
	@Transactional(readOnly=true)
	@Cacheable(value="person")//代表从缓存中查询指定的key,如果有,从缓存中取,不再执行方法.如果没有则执
	//行方法,并且将方法的返回值和指定的key关联起来,放入到缓存中.
	public Person getPersonById(Integer id) {
		log.info("调用业务逻辑方法：getPersonById");
		return pr.findById(id).get();
	}
	
	
}
