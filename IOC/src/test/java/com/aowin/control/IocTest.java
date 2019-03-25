package com.aowin.control;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.aowin.anntotation.PersonAnnoDAOImpl;
import com.aowin.cla.ClassC;
import com.aowin.cla.InterfaceOne;
import com.aowin.dao.PersonDao;
import com.aowin.dao.PersonDaoImpl;
import com.aowin.pojo.Person;
import com.aowin.transaction.PersonTransactionImpl;

class IocTest {

	@Test
	void test() {
		IocTet iocTet=new IocTet();
		iocTet.testInterface();
	}
	@Test
	void testIoc() {
		FileSystemXmlApplicationContext context=
			new FileSystemXmlApplicationContext("src/main/resources/springone.xml");
		InterfaceOne io1=(InterfaceOne) context.getBean("classa",InterfaceOne.class);
		io1.getInfo();
		
		io1=(InterfaceOne) context.getBean("classb");
		io1.getInfo();
		context.close();
	}
	@Test
	void testDI() {
		ClassPathXmlApplicationContext context2=
				new ClassPathXmlApplicationContext("springtwo.xml");
		ClassC classc=context2.getBean("classc",ClassC.class);
		System.out.println(classc);
		context2.close();
	}
	@Test   //jdbc≤‚ ‘
	void testJdbc() {
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("springjdbc.xml");
		PersonDao pd=context.getBean("personiml",PersonDaoImpl.class);
		Person person=new Person(401, "¡„≥‰", 1, "lead", 2992);
		pd.insertPerson(person);
		context.close();
	}
	@Test   //jdbc◊¢Ω‚≤‚ ‘
	void testAnnotationJdbc() {
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("springjdbcannotationtransaction.xml");
		PersonDao pd=context.getBean("personanoiml",PersonAnnoDAOImpl.class);
		Person person=new Person(405, "¡„≥‰", 1, "lead", 2992);
		pd.insertPerson(person);
		context.close();
	}
	@Test   // ¬ŒÒ≤‚ ‘
	void testTranJdbc() {
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("springjdbcannotationtransaction.xml");
		PersonTransactionImpl pd=context.getBean("personti",PersonTransactionImpl.class);
		pd.PersonService();
		context.close();
	}
	@Test   //tx ¬ŒÒ≤‚ ‘
	void testTranTxJdbc() {
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("springjdbcannotationtransaction-tx.xml");
		PersonTransactionImpl pd=context.getBean("personti",PersonTransactionImpl.class);
		pd.PersonService();
		context.close();
	}

}
