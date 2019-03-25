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
		log.info("Ŀ�����" + target);
		log.info("���ʷ�����" + method.getName());
		log.info("������" + args[0]);
		log.info("���䣺" + args[1]);
		
		int age = Integer.parseInt(args[1].toString());
		
		if(age < 1 || age > 160) {
			log.warn("��������д�ȡֵ��Χ1-160֮��");
			args[1] = 1;
		}
	}

}
