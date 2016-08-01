package com.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.CheckUtils;
import com.common.Consts;
import com.dao.UserDao;
import com.model.User;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Map<Object, Object> loginCheck(User u) {
		User user = userDao.findUserByName(u.getName());
		//System.out.println("id=" + user.getId() + ",  name=" + user.getName() + ",  password=" + user.getPassword());

		Map<Object, Object> checkRst = new HashMap<Object, Object>();

		String dbPwd = "";
		String inputPwd = "";
		if (!CheckUtils.isNull(user)) {
			dbPwd = user.getPassword();
			if (!CheckUtils.isNull(u)) {
				inputPwd = u.getPassword();
			}
			if (dbPwd.equals(inputPwd)) {
				checkRst.put(Consts.USER, user);
				checkRst.put(Consts.MSG, "Login Successed!");
			} else {
				checkRst.put(Consts.MSG, "Password Input Error!");
			}
		} else {
			checkRst.put(Consts.MSG, "User Doesn't Exist!");
		}

		return checkRst;
	}

	@Override
	public boolean register(User user) {
		User u = userDao.findUserByName(user.getName());
		if (u.getId() == 0) {
			userDao.register(user);
			return true;
		} else {
			System.out
					.println("id=" + user.getId() + ",  name=" + user.getName() + ",  password=" + user.getPassword());
			return false;
		}
	}
}
