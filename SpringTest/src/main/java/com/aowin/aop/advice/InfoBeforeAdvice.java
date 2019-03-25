package com.aowin.aop.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class InfoBeforeAdvice implements MethodBeforeAdvice{
	private Log log=LogFactory.getLog(InfoBeforeAdvice.class);
	public InfoBeforeAdvice() {
		
	}
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		log.info("目标对象：" + target);
		log.info("访问方法：" + method.getName());
		log.info("姓名：" + args[0]);
		log.info("年龄：" + args[1]);
		
		int age = Integer.parseInt(args[1].toString());
		
		if(age < 1 || age > 160) {
			log.warn("年龄参数有错，取值范围1-160之间");
			args[1] = 1;
		}
	}

}
