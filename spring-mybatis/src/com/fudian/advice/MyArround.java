package com.fudian.advice;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyArround implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("环绕-前置");
		//执行切点方法，并记录返回值
		Object result = arg0.proceed(); 
		System.out.println("环绕-后置");
		return result;
	}

	
}
