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
		log.info("目标对象：测试test");
	}
	/**Spring AOP 错误error at ::0 formal unbound in pointcut
	 *  解决方法：去掉参数后确实成功了

1. 去掉函数通知函数中的参数，

例如：
@Before("execution(* com.test.serivce..*.*(..))")
public void before(String name) {
System.out.println("前置通知:"+name);
}

改为
@Before("execution(* com.test.serivce..*.*(..))")
public void before() {
System.out.println("前置通知");
}

2 .加上args(name)  中间是before方法参数的名字

例如：

@Before("execution(* com.test.serivce..*.*(..))")
public void before(String name) {
System.out.println("前置通知:"+name);
}

改为

@Before("execution(* com.test.serivce..*.*(..))&& args(name)")
public void before(String name) {
System.out.println("前置通知:"+name);
}
	 * 
	 */
/*	@Before("execution(* com.aowin.aop.*.*(..))")
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
*/
}
