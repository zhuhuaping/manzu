package com.service;

import com.model.User;

public interface UserService {

	public boolean register(User user);

	public User loginCheck(User user);
}
