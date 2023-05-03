package com.sp.midTerm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookingdetails")
public class Booking {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    int passenger_id;
    String passenger_name;
    int ticket_id;
    String ticket_name;
 

    public Booking() {
    }

    public Booking(int passenger_id, int ticket_id) {
        this.passenger_id = passenger_id;
        this.ticket_id = ticket_id;
    }

    public Booking(int id, int passenger_id, int ticket_id) {
        this.id = id;
        this.passenger_id = passenger_id;
        this.ticket_id = ticket_id;
    }

	public String getPassenger_name() {
		return passenger_name;
	}

	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}

	public String getTicket_name() {
		return ticket_name;
	}

	public void setTicket_name(String ticket_name) {
		this.ticket_name = ticket_name;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}


}

