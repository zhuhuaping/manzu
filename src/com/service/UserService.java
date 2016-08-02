package com.service;

import java.util.Map;

import com.model.User;

public interface UserService {

	public Map<Object, Object> login(User user);

	public Map<Object, Object> register(User user);

}
