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
@Component//@component ������ͨpojoʵ������spring�����У��൱�������ļ��е�<bean id="" class=""/>��
public class InfoAroundAdvice {
	private static final long ONE_MINUTE = 60000;
	private Log logger=LogFactory.getLog(InfoAroundAdvice.class);
	public InfoAroundAdvice() {
		
	}
	@Around("execution(* com.aowin.aop.TestDaoImpl.*(..))")
	 public Object timeAround(ProceedingJoinPoint joinPoint) {
        // ���巵�ض��󡢵õ�������Ҫ�Ĳ���
        Object obj = null;
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();
        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable e) {
            logger.error("ͳ��ĳ����ִ�к�ʱ����֪ͨ����", e);
        }
 
        // ��ȡִ�еķ�����
        long endTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
 
        // ��ӡ��ʱ����Ϣ
        this.printExecTime(methodName, startTime, endTime);
 
        return obj;
    }
 
    /**
     * ��ӡ����ִ�к�ʱ����Ϣ�����������һ����ʱ�䣬�Ŵ�ӡ
     * @param methodName
     * @param startTime
     * @param endTime
     */
    private void printExecTime(String methodName, long startTime, long endTime) {
        long diffTime = endTime - startTime;
        logger.warn("-----" + methodName + " ����ִ�к�ʱ��" + diffTime + " ms");
        if (diffTime > ONE_MINUTE) {
            logger.warn("-----" + methodName + " ����ִ�к�ʱ��" + diffTime + " ms");
        }
    }
}
