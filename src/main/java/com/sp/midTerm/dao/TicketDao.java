package com.sp.midTerm.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sp.midTerm.model.Ticket;

public class TicketDao {
	JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int create(Ticket ticket) {
        return jdbcTemplate.update("insert into ticket (ticket_name, ticket_date) VALUE (?, ?)", ticket.getName(), ticket.getTicket_date());
    }

    public Ticket read(int id) {
        try {
            return jdbcTemplate.queryForObject("select * from ticket where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Ticket.class));
        } catch (Exception exception) {
            return null;
        }
    }

    public int update(Ticket ticket) {
        return jdbcTemplate.update("update ticket set ticket_name = ?, ticket_date = ? where id = ?", ticket.getName(), ticket.getTicket_date(), ticket.getId());
    }
    public int delete(int id) {
        return jdbcTemplate.update("delete from ticket where id = ?", id);
    }

    public List<Ticket> list() {
        return jdbcTemplate.query("select * from ticket", (resultSet, ticket) -> new Ticket(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
    }
    
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from ticket", Integer.class);
    }

}
