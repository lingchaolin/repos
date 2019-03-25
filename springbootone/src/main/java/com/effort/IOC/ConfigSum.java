package com.effort.IOC;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ConfigOne.class,ConfigTwo.class})//将两个配置合并到一起
public class ConfigSum { }
