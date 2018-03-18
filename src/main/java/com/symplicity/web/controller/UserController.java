package com.symplicity.web.controller;

import com.symplicity.base.FireBaseUtil;
import com.symplicity.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
   @Autowired
    private FireBaseUtil fireBaseUtil;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView user() {
        User user = new User();
//        user.setFavoriteFrameworks((new String []{"Spring MVC","Struts 2"}));
        user.setFruit("Apple");
        ModelAndView modelAndView = new ModelAndView("user", "command", user);
        return modelAndView;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("SpringWeb")User user, ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName(); //get logged in username
        fireBaseUtil.saveVote(userName,user.getFruit());

        model.addAttribute("fruit", user.getFruit());
        return "users";
    }

}
