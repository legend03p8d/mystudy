package com.fudian.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fudian.mapper.FilesMapper;
import com.fudian.pojo.Files;
import com.fudian.pojo.Users;
import com.fudian.service.FilesService;

@Service
public class FilesServiceImpl implements FilesService {

	@Resource
	private FilesMapper filesMapper;
	
	@Override
	public List<Files> showAll() {
		return filesMapper.selAll();
	}

	@Override
	public int updCount(int id, Users users, String name) {
		Logger logger = Logger.getLogger(FilesServiceImpl.class);
		logger.info(users.getUsername()+"下载了"+name);
		return filesMapper.updCountById(id);
	}

}
