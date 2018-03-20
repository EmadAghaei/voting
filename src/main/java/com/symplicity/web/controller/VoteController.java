package com.symplicity.web.controller;

import com.symplicity.base.FireBaseUtil;
import com.symplicity.web.model.Vote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class VoteController {

   @Autowired
    private FireBaseUtil fireBaseUtil;

    @RequestMapping(value = "/vote", method = RequestMethod.GET)
    public ModelAndView vote() {

        Vote vote = new Vote();
        vote.setFruit("Apple");
        ModelAndView modelAndView = new ModelAndView("vote", "command", vote);
        return modelAndView;
    }

    @RequestMapping(value = "/addVote", method = RequestMethod.POST)
    public String addVote(@ModelAttribute("vote")Vote vote, ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName(); //get logged in username
        fireBaseUtil.saveVote(userName, vote.getFruit());
        Map<String,Integer> fruitCounts = null;
       fruitCounts = fireBaseUtil.getVotes();
        model.addAttribute("fruit", vote.getFruit());
        model.addAttribute("votes",fruitCounts);
        return "votes";
    }

}
