package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.common.MD5Utils;
import com.dao.UserDao;
import com.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void register(User user) {
		String sqlStr = "INSERT INTO tb_user(name,password,gender,mobile,address,create_datetime,update_datetime) VALUES(?,?,?,?,?,?,?)";
		Object[] params = new Object[] { user.getName(), MD5Utils.encode(user.getPassword()), user.getGender(),
				user.getMobile(), user.getAddress(), new Date(), new Date() };
		jdbcTemplate.update(sqlStr, params);
	}

	@Override
	public User findUserByName(String name) {
		String sqlStr = "SELECT ID,NAME,PASSWORD FROM tb_user WHERE NAME = ?";
		final User user = new User();
		jdbcTemplate.query(sqlStr, new Object[] { name }, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
			}
		});
		return user;
	}

}
