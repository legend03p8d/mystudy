package com.fudian.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.fudian.pojo.Users;
import com.fudian.service.UsersService;

@Controller
public class UsersController {

	@Resource
	private UsersService usersServiceImpl;
	
	@RequestMapping("register")
	public String register(Users users,MultipartFile file,HttpServletRequest req){
		String fileName = UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String path = req.getServletContext().getRealPath("images")+"/"+fileName;
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//只能取到webapps文件夹内容
		users.setPhoto(fileName);
		int index = usersServiceImpl.insUser(users);
		if(index>0){
			req.getSession().setAttribute("user", users);
			return "redirect:/index.jsp";
		}else{
			return "redirect:/register.jsp";
		}
	}
	
	@RequestMapping("login")
	public String login(HttpServletRequest req, HttpServletResponse resp){
		String code = req.getParameter("code");
		String codeSession = req.getSession().getAttribute("code").toString();
		if(codeSession.equals(code)){
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			Users users = new Users();
			users.setPassword(password);
			users.setUsername(username);
			Users user = usersServiceImpl.login(users);
			if(user!=null){
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				return("main");
			}else{
				req.setAttribute("error", "用户名密码不正确");
				return "index";
			}
		}else{
			req.setAttribute("error", "验证码不正确");
			//req.getRequestDispatcher("index.jsp").forward(req, resp);
			return "index";
		}
	}
	
}
