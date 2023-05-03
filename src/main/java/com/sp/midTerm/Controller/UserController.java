package com.sp.midTerm.Controller;


import com.sp.midTerm.dao.UserDao;
import com.sp.midTerm.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class UserController {
	UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping("user/sign-up")
    public String signUp(Model model) {
        model.addAttribute("user" ,new User());
        return "sign-up";
    }
    @PostMapping("user/sign-up")
    public String signUp(@ModelAttribute("user") User user) {
        userDao.create(user);
        return "redirect:/home";
    }
    @RequestMapping(value="user/sign-in")
    public String signIn(Model model) {
        model.addAttribute("user" ,new User());
        return "sign-in";
    }
    @RequestMapping(value="user/sign-in", method = RequestMethod.POST)
    public String signIn(@ModelAttribute("user") User user) {
        User user1 = userDao.read(user.getUsername());
        if (user1 != null) {
            if (user1.getPassword().equals(user.getPassword())) {
                return "redirect:/home";
            }
        }
        return "redirect:/user/sign-in";
    }

    @RequestMapping(value="/home")
    public String index() {
        return "home";
    }
}