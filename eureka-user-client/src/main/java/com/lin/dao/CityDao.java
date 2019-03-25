package com.lin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lin.pojo.City;
@Mapper
public interface CityDao {

	City findById(@Param("id") Long id);
}
