package com.aowin.annotation.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;
@Aspect
@Component//@component （把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）
public class InfoAroundAdvice {
	private static final long ONE_MINUTE = 60000;
	private Log logger=LogFactory.getLog(InfoAroundAdvice.class);
	public InfoAroundAdvice() {
		
	}
	@Around("execution(* com.aowin.aop.TestDaoImpl.*(..))")
	 public Object timeAround(ProceedingJoinPoint joinPoint) {
        // 定义返回对象、得到方法需要的参数
        Object obj = null;
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();
        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable e) {
            logger.error("统计某方法执行耗时环绕通知出错", e);
        }
 
        // 获取执行的方法名
        long endTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
 
        // 打印耗时的信息
        this.printExecTime(methodName, startTime, endTime);
 
        return obj;
    }
 
    /**
     * 打印方法执行耗时的信息，如果超过了一定的时间，才打印
     * @param methodName
     * @param startTime
     * @param endTime
     */
    private void printExecTime(String methodName, long startTime, long endTime) {
        long diffTime = endTime - startTime;
        logger.warn("-----" + methodName + " 方法执行耗时：" + diffTime + " ms");
        if (diffTime > ONE_MINUTE) {
            logger.warn("-----" + methodName + " 方法执行耗时：" + diffTime + " ms");
        }
    }
}
