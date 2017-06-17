package com.neuedu.user.mapper;

import com.neuedu.user.entity.User;

public interface  UserMapper {
	 
	public User getUser(String name);
	
	public void insertUser(User user);

}
