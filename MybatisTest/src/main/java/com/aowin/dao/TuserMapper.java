package com.aowin.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.aowin.model.People;

public interface TuserMapper {
/**
 * 基本的增删改查方法
 */
	public int insertUser(People people);
	public int batchInserta(ArrayList<People> list);
	public int batchInsertb(ArrayList<People> list);
	public int updateUser(Map<String,Object> map);
	public int deleteUser(ArrayList<Integer> list);
//	注解传参
	public ArrayList<People> selectUser(@Param(value="id")Integer id,@Param(value="name")String name);
	public ArrayList<People> selectMapUser(Map<String,Object> map);
	//模糊查询
	public ArrayList<People> selectLikeUser(Map<String,Object> map);
	public ArrayList<People> selectWhereUser(Map<String,Object> map);
	public ArrayList<People> selectChooseUser(Map<String,Object> map);
	public ArrayList<People> selectUriUser();
	public ArrayList<People> selectResultMap(long id);//测试resultMap
}
