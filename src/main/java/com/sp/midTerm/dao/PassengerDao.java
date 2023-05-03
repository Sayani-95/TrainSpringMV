package com.sp.midTerm.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sp.midTerm.model.Passenger;

public class PassengerDao {
	JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int create(Passenger passenger) {
        return jdbcTemplate.update("insert into passenger (name, gender, email) VALUE (?, ?, ?)", passenger.getName(), passenger.getGender(), passenger.getEmail());
    }

    public Passenger read(int id) {
        try {
            return jdbcTemplate.queryForObject("select * from passenger where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Passenger.class));
        } catch (Exception exception) {
            return null;
        }
    }

    public int update(Passenger passenger) {
        int update = jdbcTemplate.update("update passenger set name = ?, gender = ?, email= ? where id = ?",  passenger.getName(), passenger.getGender(), passenger.getEmail(), passenger.getId());
        return update;
    }
    public int delete(int id) {
        return jdbcTemplate.update("delete from passenger where id = ?", id);
    }

    public List<Passenger> list() {
        return jdbcTemplate.query("select * from passenger", (resultSet, passenger) -> new Passenger(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
    }
//    public List<Passenger> passengerName() {
//    	return jdbcTemplate .query("select name from passenger", (resultSet, passenger) -> new Passenger(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
//    }
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from passenger", Integer.class);
    }

}

