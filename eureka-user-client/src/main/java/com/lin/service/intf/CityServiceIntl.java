package com.lin.service.intf;

import org.apache.ibatis.annotations.Param;

import com.lin.pojo.City;

public interface CityServiceIntl {

    City findById(@Param("id") Long id);//参数名:id   值：${id}
}
