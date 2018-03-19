package com.symplicity.web.controller;

import com.symplicity.base.FireBaseUtil;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
public class MainController {

	private final org.slf4j.Logger logger = LoggerFactory.getLogger(MainController.class);
	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		logger.info("Login request is revived");
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
			logger.info("Invalid username and password!");
		}
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

}