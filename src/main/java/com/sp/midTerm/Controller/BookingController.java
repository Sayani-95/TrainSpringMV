package com.sp.midTerm.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sp.midTerm.dao.BookingDao;
import com.sp.midTerm.dao.PassengerDao;
import com.sp.midTerm.dao.TicketDao;
import com.sp.midTerm.model.Booking;
import com.sp.midTerm.model.Passenger;
import com.sp.midTerm.model.Ticket;

@Controller
public class BookingController {
    BookingDao bookingDao;
    PassengerDao passengerDao;
    TicketDao ticketDao;

    public BookingController(BookingDao bookingDao, PassengerDao passengerDao, TicketDao ticketDao) {
        this.bookingDao = bookingDao;
        this.passengerDao = passengerDao;
        this.ticketDao = ticketDao;
    }

    @RequestMapping("booking/create")
    public String create(Model model) {
        if (passengerDao.count() == 0) {
            return "redirect:/passenger/create";
        }
        if (ticketDao.count() == 0) {
            return "redirect:/ticket/create";
        }
        model.addAttribute("booking", new Booking());
        model.addAttribute("passenger", passengerDao.list());
        model.addAttribute("ticket", ticketDao.list());
        return "booking-create";
    }

    @PostMapping(value="booking/create")
    public String create(@ModelAttribute("booking") Booking booking) {
        bookingDao.create(booking);
        return "redirect:/booking/record";
    }

    @RequestMapping("/booking/record")
    public String list(Model model) {
        List<Booking> bookings = bookingDao.getBookings();
        for (Booking booking:
             bookings) {
            addPassengerAndTicket(booking);
        }
        model.addAttribute("bookings", bookings);
        return "booking-list";
    }
	
	
	@RequestMapping(value="booking/update/{id}")
    public String update(@PathVariable int id, Model model) {
        Booking booking = bookingDao.read(id);
        addPassengerAndTicket(booking);
        model.addAttribute("booking", booking);
        model.addAttribute("passenger", passengerDao.list());
        model.addAttribute("ticket", ticketDao.list());
        return "visit-update";
    }

    @PostMapping(value="booking/update")
    public String update(@ModelAttribute("booking") Booking booking) {
        bookingDao.update(booking);
        return "redirect:/booking/record";
    }

   
    private void addPassengerAndTicket(Booking booking) {
  	  Passenger passenger = passengerDao.read(booking.getPassenger_id());
        Ticket ticket = ticketDao.read(booking.getTicket_id());
        booking.setPassenger_name(passenger.getName()+ " - "+passenger.getGender()+ " - "+passenger.getEmail());
        booking.setTicket_name(ticket.getName() + " - " + ticket.getTicket_date());
    }
}
