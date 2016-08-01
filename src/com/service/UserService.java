package com.service;

import java.util.Map;

import com.model.User;

public interface UserService {

	public boolean register(User user);

	public Map<Object, Object> loginCheck(User user);
}
