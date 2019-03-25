package com.aowin.dao;

import com.aowin.model.People;

public class PeopleDaoImpl implements PeopleDao{

	public PeopleDaoImpl() {
	}

	@Override
	public boolean insertPeople(People people) {
		boolean flag=false;
		String sql="insert into Person(id,name,sex,department,salary) values (?,?,?,?,?)";
/*		int i=super.getJdbcTemplate().update(sql,person.getId(),person.getName(),
				person.getSex(),person.getDepart(),person.getSalary());*/
	/*	if(i!=0) {
			flag=true;
		}*/
		return flag;
	}

}
