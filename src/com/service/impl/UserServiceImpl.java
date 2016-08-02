package com.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.CheckUtils;
import com.common.Consts;
import com.common.MD5Utils;
import com.common.Enum.Reg_Rst;
import com.dao.UserDao;
import com.model.User;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Map<Object, Object> login(User inputUser) {
		Map<Object, Object> checkRst = new HashMap<Object, Object>();

		User dbUser = userDao.findUserByName(inputUser.getName());
		String dbPwd = "";
		String inputPwd = "";

		if (!CheckUtils.isNull(dbUser) && dbUser.getId() > 0) {
			dbPwd = dbUser.getPassword();

			if (!CheckUtils.isNull(inputUser)) {
				inputPwd = inputUser.getPassword();
			}

			if (CheckUtils.isStrEquals(dbPwd, MD5Utils.encode(inputPwd))) {
				checkRst.put(Consts.USER, dbUser);
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
	public Map<Object, Object> register(User user) {
		Map<Object, Object> checkRst = new HashMap<Object, Object>();

		User dbUser = userDao.findUserByName(user.getName());

		if (dbUser.getId() == 0) {
			userDao.register(user);
			checkRst.put(Consts.REG_RST, Reg_Rst.SUCCESS);
			checkRst.put(Consts.MSG, "Register Successed!");
		} else {
			checkRst.put(Consts.REG_RST, Reg_Rst.FAIL);
			checkRst.put(Consts.MSG, "The User Already Exists!");
		}

		return checkRst;
	}
}
