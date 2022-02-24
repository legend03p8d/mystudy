package com.fudian.service.impl;

import org.springframework.beans.factory.annotation.Value;

import com.fudian.mapper.UsersMapper;
import com.fudian.pojo.Users;
import com.fudian.service.UsersService;

public class UsersServiceImpl implements UsersService {
	
	//以下展示从Spring容器中取出属性文件的值
	@Value("${jdbc.username}")
	private String dbUser;
	
	private UsersMapper usersMapper;
	
	public UsersMapper getUsersMapper() {
		return usersMapper;
	}

	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}
	
	@Override
	public Users login(Users users) {
		System.out.println(dbUser);
		return usersMapper.selByUsers(users);
	}

	@Override
	public int insUser(Users users) {
		return usersMapper.insUsers(users);
	}
}
