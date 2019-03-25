package com.lin.service.intf;

import org.apache.ibatis.annotations.Param;

import com.lin.pojo.User;

public interface UserServiceIntl {
    User findByName(@Param("name") String name);
}
