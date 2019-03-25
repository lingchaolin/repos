package com.aowin.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.aowin.model.Appraise;
import com.aowin.model.People;

public interface AppraiseMapper {
/**
 * 增删改查
 * list
 * map
 * 普通类型
 */
	public int insertAppraise(Appraise appraise);
	public int insertAppraiseMap(Map<String, Object> map);
	public int deleteAppraise(Appraise  appraise);
	public int updateAppraise(Appraise appraise);
	public ArrayList<Appraise> selectAppraise(int appraiseId);
	
	
	public int updateAppraise2(Map<String,Object> map);
	public ArrayList<People> selectAppraise2(Map<String,Object> map);
}
