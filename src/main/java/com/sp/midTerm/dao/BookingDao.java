package com.sp.midTerm.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sp.midTerm.model.Booking;

public class BookingDao {
	JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int create(Booking booking) {
        return jdbcTemplate.update("insert into bookingdetails (passenger_id, ticket_id) VALUE (?, ?)", booking.getPassenger_id(), booking.getTicket_id());
    }

    public Booking read(int id) {
        try {
            return jdbcTemplate.queryForObject("select * from bookingdetails where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Booking.class));
        } catch (Exception exception) {
            return null;
        }
    }

    public int update(Booking booking) {
        return jdbcTemplate.update("update bookingdetails set passenger_id = ?, ticket_id = ? where id = ?", booking.getPassenger_id(), booking.getTicket_id(), booking.getId());
    }

    public int delete(int id) {
        return jdbcTemplate.update("delete from bookingdetails where id = ?", id);
    }

    public List<Booking> getBookings() {
        return jdbcTemplate.query("select * from bookingdetails", (resultSet, booking) -> new Booking(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3)));
    }


}