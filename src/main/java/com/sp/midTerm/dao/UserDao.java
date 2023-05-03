package com.sp.midTerm.dao;


import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sp.midTerm.model.User;

public class UserDao {
	 JdbcTemplate jdbcTemplate;

	    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	    public int create(User user) {
	        return jdbcTemplate.update("insert into user (username, password) VALUE (?, ?)", user.getUsername(), user.getPassword());
	    }

	    public User read(int id) {
	        try {
	            return jdbcTemplate.queryForObject("select * from user where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
	        } catch (Exception exception) {
	            return null;
	        }
	    }

	    public User read(String username) {
	        try {
	            return jdbcTemplate.queryForObject("select * from user where username = ?", new Object[]{username}, new BeanPropertyRowMapper<>(User.class));
	        } catch (Exception exception) {
	            return null;
	        }
	    }

	    public int update(User user) {
	        return jdbcTemplate.update("update user set username = ?, password = ? where id = ?", user.getUsername(), user.getPassword(), user.getId());
	    }
	    public int delete(int id) {
	        return jdbcTemplate.update("delete from user where id = ?", id);
	    }

	    public List<User> getUsers() {
	        return jdbcTemplate.query("select * from user", (resultSet, user) -> new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
	    }
}
