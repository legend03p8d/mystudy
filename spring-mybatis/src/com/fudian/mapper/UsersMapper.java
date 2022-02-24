package com.fudian.mapper;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.fudian.pojo.Users;

public interface UsersMapper {
	@Select("select * from users where username=#{username} and password=#{password}")
	Users selByUsersPwd(Users users);
	
	int insUsers(Users users);
	
	@Results(value={
			@Result(id=true,column="id",property="id"),
			@Result(column="username",property="username"),
			@Result(column="password",property="password"),
			@Result(property="menus",many=@Many(select=
					"com.fudian.mapper.MenuMapper.selByPid"),
					column="{uid=id,pid=pid}")
			})
	//如果需要传递多个参数 column="{"key"=列名,"key"=列名}"  key自定义
	//另一个查询中获取传递过来的参数  #{key}
	//本例展示用注解的方式来写映射查询结果
	@Select("select *,0 pid from users where username=#{username} and password=#{password}")
	Users selByUsers(Users users);
}
