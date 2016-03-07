package com.polifr.demo.maven.webapp.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {

	@RequestMapping("/homePage.html")
	public ModelAndView homePage() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("myMessage", "Questa è la Home Page.");
		model.put("myTime", Calendar.getInstance());
		return new ModelAndView("homePage", model);
	}
}
