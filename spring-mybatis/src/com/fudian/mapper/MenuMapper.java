package com.fudian.mapper;

import java.util.List;
import java.util.Map;

import com.fudian.pojo.Menu;

public interface MenuMapper {
	List<Menu> selByPid(Map<String,Object> map);
}
