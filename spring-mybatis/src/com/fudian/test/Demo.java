package com.fudian.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public void demo01(){
		System.out.println("demo01执行");
	}
	
	public void demo02(){
		int i=5/0;
		System.out.println("demo02执行");
	}
	
	public void demo03(){
		System.out.println("demo03执行");
	}
	
	public void demo04(String name){
		System.out.println("demo04执行："+name);
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		String[] names = ac.getBeanDefinitionNames();
//		for(String s:names){
//			System.out.println(s);
//		}
		Demo demo = ac.getBean("demo", Demo.class);
		demo.demo01();
		System.out.println("-----------------------------");
		try{
			demo.demo02();
		} catch(Exception e){
			//do-nothing
		}
		System.out.println("-----------------------------");
		demo.demo03();
		System.out.println("-----------------------------");
		demo.demo04("张三");
	}

}
