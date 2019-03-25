package com.effort.jpatest.respository;
import com.effort.jpatest.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PersonRepository extends JpaRepository<Person, Integer>{
	//代替Dao方法？？
}
