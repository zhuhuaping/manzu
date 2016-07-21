package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.User;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User loginCheck(User user) {
		User u = userDao.findUserByUserName(user.getName());
		System.out.println("id=" + u.getId() + ",  userName=" + u.getName() + ", password=" + u.getPassword());
		if (user.getPassword().equals(u.getPassword())) {
			return u;
		} else {
			return null;
		}
	}

	@Override
	public boolean register(User user) {
		User u = userDao.findUserByUserName(user.getName());
		if (u.getId() == 0) {
			userDao.register(user);
			return true;
		} else {
			System.out.println("id=" + u.getId() + ",  userName=" + u.getName() + ", password=" + u.getPassword());
			return false;
		}
	}
}
