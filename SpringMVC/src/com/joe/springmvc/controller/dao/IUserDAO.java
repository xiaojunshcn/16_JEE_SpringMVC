package com.joe.springmvc.controller.dao;

import java.util.List;
import com.joe.springmvc.vo.User;

public interface IUserDAO {
	public void addUser(User user);
	
	public List<User> getAllUser();
	
	public boolean delUser(String id);
	
	public User getUser(String id);
	
	public boolean updateUser(User user);
}
