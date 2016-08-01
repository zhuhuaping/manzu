package com.dao;

import com.model.User;

public interface UserDao {

	public void register(User user);

	public User findUserByName(final String userName);
}
