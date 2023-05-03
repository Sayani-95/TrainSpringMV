package com.sp.midTerm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String ticket_date;
    

    public Ticket() {
    }

    public Ticket(int id) {
        this.id = id;
    }

    public Ticket(String name, String ticket_date) {
        this.name = name;
        this.ticket_date = ticket_date;
        
    }

    public Ticket(int id, String name, String ticket_date) {
        this.id = id;
    	this.name = name;
        this.ticket_date = ticket_date;
        
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTicket_date() {
		return ticket_date;
	}

	public void setTicket_date(String ticket_date) {
		this.ticket_date = ticket_date;
	}
}