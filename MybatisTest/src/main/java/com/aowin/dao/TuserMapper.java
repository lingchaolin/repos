package com.aowin.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.aowin.model.People;

public interface TuserMapper {
/**
 * ��������ɾ�Ĳ鷽��
 */
	public int insertUser(People people);
	public int batchInserta(ArrayList<People> list);
	public int batchInsertb(ArrayList<People> list);
	public int updateUser(Map<String,Object> map);
	public int deleteUser(ArrayList<Integer> list);
//	ע�⴫��
	public ArrayList<People> selectUser(@Param(value="id")Integer id,@Param(value="name")String name);
	public ArrayList<People> selectMapUser(Map<String,Object> map);
	//ģ����ѯ
	public ArrayList<People> selectLikeUser(Map<String,Object> map);
	public ArrayList<People> selectWhereUser(Map<String,Object> map);
	public ArrayList<People> selectChooseUser(Map<String,Object> map);
	public ArrayList<People> selectUriUser();
	public ArrayList<People> selectResultMap(long id);//����resultMap
}
