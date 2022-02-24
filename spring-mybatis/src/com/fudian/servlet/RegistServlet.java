package com.fudian.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.fudian.pojo.Users;
import com.fudian.service.UsersService;
import com.fudian.service.impl.UsersServiceImpl;

//tomcat是精确匹配，如果Servlet被匹配，将不走DispatcherServlet
@WebServlet("/regist")
public class RegistServlet extends HttpServlet{
	private UsersService usersService;
	
	@Override
	public void init() throws ServletException {
		ApplicationContext ac  = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		usersService=ac.getBean("usersService",UsersServiceImpl.class);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Servlet被执行");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		int result = usersService.insUser(user);
		if(result>0){
			resp.sendRedirect("index.jsp");
		}else{
			req.setAttribute("error", "用户注册失败");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
		
	}

}
