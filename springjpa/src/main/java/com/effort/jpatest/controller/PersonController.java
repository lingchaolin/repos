package com.effort.jpatest.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.effort.jpatest.pojo.Person;
import com.effort.jpatest.service.PersonService;



@RestController
public class PersonController {
	private Log log=LogFactory.getLog(PersonController.class);
	public  PersonController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private PersonService personService;
	@RequestMapping(value="/addstudent")
	public String addPerson() {
		log.info("调用处理方法：addPerson");
		Person p=new Person();
		p.setId(1454);
		p.setName("张三");
		p.setSex(1);
		p.setSalary(1311);
		p.setDepartment("lead");
		System.out.println("参数设置完成");
		System.out.println("person:"+p);

		String info=null;
		try {
			personService.insertPerson(p);
			info="添加成功";
		} catch (Exception e) {
			info="添加失败";
			log.warn(info+":"+e);
		}
		return info;
	}
	@RequestMapping(value="/showpersons/{pages}")
	public List<Person> showPersons(@PathVariable int pages){
		log.info("调用处理方法：showpersons()");
		Page<Person> person=personService.getPersons(pages, 3); 
		log.info("总页数：" + person.getTotalPages());
		return person.getContent();
	}
	@RequestMapping(value="/showperson/{id}")
	public Person showPerson(@PathVariable int id){
		log.info("调用处理方法：showperson()");
		return personService.getPersonById(id);
	}
}
