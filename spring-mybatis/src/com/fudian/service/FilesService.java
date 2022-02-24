package com.fudian.service;

import java.util.List;

import com.fudian.pojo.Files;
import com.fudian.pojo.Users;

public interface FilesService {

	List<Files> showAll();
	
	int updCount(int id,Users users,String name);
}
