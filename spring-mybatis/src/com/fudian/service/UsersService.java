package com.fudian.service;

import com.fudian.pojo.Users;

public interface UsersService {
	/**
	 * 登录
	 * @param users
	 * @return
	 */
	Users login(Users users);
	
	/**
	 * 新增用户
	 * @param users
	 * @return
	 */
	int insUser(Users users);
}
