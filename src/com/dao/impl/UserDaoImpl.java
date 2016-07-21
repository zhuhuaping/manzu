package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void register(User user) {
		String sqlStr = "insert into user(uname,pwd) values(?,?)";
		Object[] params = new Object[] { user.getName(), user.getPassword() };
		jdbcTemplate.update(sqlStr, params);
	}

	@Override
	public User findUserByUserName(String userName) {
		String sqlStr = "select id,uname,pwd from user where uname=?";
		final User user = new User();
		jdbcTemplate.query(sqlStr, new Object[] { userName }, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("uname"));
				user.setPassword(rs.getString("pwd"));
			}
		});
		return user;
	}

}
