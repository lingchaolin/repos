package com.lin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lin.pojo.User;
@Mapper
public interface UserDao {

    User findByName(@Param("name") String name);

}
