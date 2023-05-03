package com.sp.midTerm.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.midTerm.dao.PassengerDao;
import com.sp.midTerm.model.Passenger;

@Controller
@RequestMapping
public class PassengerController {
    PassengerDao passengerDao;

    public PassengerController(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }

    @RequestMapping("passenger/create")
    public String create(Model model) {
        model.addAttribute("passenger", new Passenger());
        return "passenger-create";
    }

    @PostMapping(value="passenger/create")
    public String create(@ModelAttribute("create") Passenger passenger) {
    	passengerDao.create(passenger);
        return "redirect:/passenger/record";
    }

    @RequestMapping("passenger/record")
    public String list(Model model) {
        List<Passenger> passenger = passengerDao.list();
        model.addAttribute("passenger", passenger);
        return "passenger-list";
    }
    @RequestMapping(value="passenger/edit/{id}")
    public String update(@PathVariable int id, Model model) {
        Passenger passenger = passengerDao.read(id);
        model.addAttribute("passenger", passenger);
        return "passenger-edit";
    }

    @RequestMapping(value="passenger/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("passenger") Passenger passenger) {
    	passengerDao.update(passenger);
        return "redirect:http://localhost:8080/TrainSpringMvc/passenger/record";
    }

}