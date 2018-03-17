package com.symplicity.web.controller;

import com.symplicity.web.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView user() {
        User user = new User();
//        user.setFavoriteFrameworks((new String []{"Spring MVC","Struts 2"}));
        user.setFruit("Apple");
        ModelAndView modelAndView = new ModelAndView("user", "command", user);
        return modelAndView;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("SpringWeb")User user,
                          ModelMap model) {

        model.addAttribute("fruit", user.getFruit());
        return "users";
    }

}
