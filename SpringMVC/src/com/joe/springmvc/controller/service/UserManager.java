package com.joe.springmvc.controller.service;

import java.util.List;
import com.joe.springmvc.controller.dao.IUserDAO;
import com.joe.springmvc.vo.User;

public class UserManager implements IUserManager {
	
	private IUserDAO userDao;
	
	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	public void addUser(User user) {
		userDao.addUser(user);
	}

	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	public boolean delUser(String id) {
		return userDao.delUser(id);
	}

	public User getUser(String id) {
		return userDao.getUser(id);
	}

	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}
}