package com.fudian.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fudian.mapper.MenuMapper;
import com.fudian.pojo.Menu;
import com.fudian.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Resource
	private MenuMapper menuMapper;
	
	public List<Menu> show() {
		Map map= new HashMap();
		map.put("uid", 0);
		map.put("pid", 0);
		return menuMapper.selByPid(map);
	}

}
