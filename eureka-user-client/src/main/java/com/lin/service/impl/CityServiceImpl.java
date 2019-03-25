package com.lin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.dao.CityDao;
import com.lin.pojo.City;
import com.lin.service.intf.CityServiceIntl;

@Service
public class CityServiceImpl implements CityServiceIntl{
	@Autowired
	private CityDao cityDao;
	public City findById(Long id) {

		return cityDao.findById(id);
	}

}
