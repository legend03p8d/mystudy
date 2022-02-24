package com.fudian.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fudian.pojo.Menu;
import com.fudian.pojo.Users;
import com.fudian.service.MenuService;

@Controller
public class MenuController {
	
	/**
	 * springmvc容器调用spring容器中内容
	 */
	
	@Resource
	private MenuService menuServiceImpl;
	
	@RequestMapping("show")
	@ResponseBody
	public List<Menu> show(HttpServletRequest req){
		//这里不担心是否能读取到user信息是因为加了拦截器，若session中没有将会重新登录
		Users user = (Users) req.getSession().getAttribute("user");
		return user.getMenus();
	}


}
