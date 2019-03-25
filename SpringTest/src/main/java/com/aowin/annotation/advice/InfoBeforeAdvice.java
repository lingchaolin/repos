package com.aowin.annotation.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.MethodBeforeAdvice;
@Aspect
public class InfoBeforeAdvice {
	private Log log=LogFactory.getLog(InfoBeforeAdvice.class);
	public InfoBeforeAdvice() {
		
	}
	@Before("execution(* com.aowin.aop.*.*(..))")
	public void before() throws Throwable {
		log.info("Ŀ����󣺲���test");
	}
	/**Spring AOP ����error at ::0 formal unbound in pointcut
	 *  ���������ȥ��������ȷʵ�ɹ���

1. ȥ������֪ͨ�����еĲ�����

���磺
@Before("execution(* com.test.serivce..*.*(..))")
public void before(String name) {
System.out.println("ǰ��֪ͨ:"+name);
}

��Ϊ
@Before("execution(* com.test.serivce..*.*(..))")
public void before() {
System.out.println("ǰ��֪ͨ");
}

2 .����args(name)  �м���before��������������

���磺

@Before("execution(* com.test.serivce..*.*(..))")
public void before(String name) {
System.out.println("ǰ��֪ͨ:"+name);
}

��Ϊ

@Before("execution(* com.test.serivce..*.*(..))&& args(name)")
public void before(String name) {
System.out.println("ǰ��֪ͨ:"+name);
}
	 * 
	 */
/*	@Before("execution(* com.aowin.aop.*.*(..))")
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
*/
}
