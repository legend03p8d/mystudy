package com.fudian.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
//用于Aspect方式的aop，不需要实现接口
public class MyAdvice {

	public void myafter(){
		System.out.println("后置1");
	}

	public void myafterreturn(){
		System.out.println("后置2");
	}
	
	public Object myarround(ProceedingJoinPoint p) throws Throwable{
		System.out.println("Aspect环绕前");
		Object result = p.proceed();
		System.out.println("Aspect环绕后");
		return result;
	}
	
	public void mybefore(String name){
		System.out.println(name+"--前置通知");
	}
}

