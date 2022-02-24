package com.fudian.advice;

public class MyThrowAdvice {
	
	public void myexception(Exception e1){
		System.out.println("执行异常通知："+e1.getMessage());
	}

}
