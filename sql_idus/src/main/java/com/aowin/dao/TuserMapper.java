package com.aowin.dao;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.aowin.model.Person;

public interface TuserMapper {
	public int insertUser(Person person);
	public int batchInsert(ArrayList<Person> list);
	public int updateUser(Map<String,Object> map);
	public int deleteUser(ArrayList<Integer> list);
	public ArrayList<Person> selectUser(@Param(value="id")Integer id,@Param(value="name")String name);
	public ArrayList<Person> selectMapUser(Map<String,Object> map);
	public ArrayList<Person> selectLikeUser(Map<String,Object> map);
	public ArrayList<Person> selectWhereUser(Map<String,Object> map);
	public ArrayList<Person> selectChooseUser(Map<String,Object> map);
	public ArrayList<Person> selectUriUser();
	public ArrayList<Person> selectResultMap(long id);//≤‚ ‘resultMap
}
