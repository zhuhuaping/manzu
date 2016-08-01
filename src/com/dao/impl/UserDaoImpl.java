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
	public User findUserByName(String name) {
		String sqlStr = "SELECT ID,NAME,PASSWORD FROM tb_user WHERE NAME = ?";
		final User user = null;
		jdbcTemplate.query(sqlStr, new Object[] { name }, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
			}
		});
		return user;
	}

}
