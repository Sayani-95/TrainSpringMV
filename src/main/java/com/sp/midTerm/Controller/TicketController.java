package com.sp.midTerm.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sp.midTerm.dao.TicketDao;
import com.sp.midTerm.model.Ticket;

@Controller
public class TicketController {
    TicketDao ticketDao;

    public TicketController(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @RequestMapping("ticket/create")
    public String create(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "ticket-create";
    }

    @PostMapping(value="ticket/create")
    public String create(@ModelAttribute("ticket") Ticket ticket) {
    	ticketDao.create(ticket);
        return "redirect:/ticket/record";
    }

    @RequestMapping("ticket/record")
    public String list(Model model) {
        List<Ticket> ticket = ticketDao.list();
        model.addAttribute("ticket", ticket);
        return "ticket-list";
    }
    @RequestMapping(value="ticket/edit/{id}")
    public String update(@PathVariable int id, Model model) {
        Ticket ticket = ticketDao.read(id);
        model.addAttribute("ticket", ticket);
        return "ticket-edit";
    }

    @PostMapping(value="ticket/update")
    public String update(@ModelAttribute("ticket") Ticket ticket) {
    	ticketDao.update(ticket);
        return "redirect:http://localhost:8080/TrainSpringMvc/ticket/record";
    }

}
