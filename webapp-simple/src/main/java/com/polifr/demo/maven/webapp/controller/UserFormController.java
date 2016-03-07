package com.polifr.demo.maven.webapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.polifr.demo.maven.webapp.model.User;
import com.polifr.demo.maven.webapp.repository.UserDao;

@Controller
public class UserFormController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/addUser.html", method = RequestMethod.GET)
	public String prepareAddUser(@ModelAttribute User user, Model model) {
		model.addAttribute("user", user);
		return "newUserPage";
	}

	
	@RequestMapping(value = "/addUser.html", method = RequestMethod.POST)
	public String addUserSubmit(@Valid @ModelAttribute User user, BindingResult bindingResults, Model model) {
		if(bindingResults.hasErrors()) {
			model.addAttribute("user", user);
			return "newUserPage";
		}
		
		userDao.addUser(user);
		
		return "redirect:/listUsers.html";
	}
}
