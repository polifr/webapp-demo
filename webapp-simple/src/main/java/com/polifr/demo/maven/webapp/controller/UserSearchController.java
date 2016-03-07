package com.polifr.demo.maven.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.polifr.demo.maven.webapp.model.User;
import com.polifr.demo.maven.webapp.repository.UserDao;

@Controller
public class UserSearchController {

	@Autowired
	private UserDao userDao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping(value = "/searchUsers.html", method = RequestMethod.GET)
	public String prepareAddUser(@ModelAttribute User user, Model model) {
		model.addAttribute("user", user);
		return "searchUsersPage";
	}

	@RequestMapping(value = "/searchUsers.html", method = RequestMethod.POST)
	public String addUserSubmit(@ModelAttribute User user, Model model) {
		List<User> users = userDao.findUsersByExample(user);
		model.addAttribute("users", users);
		return "searchUsersPage";
	}

}
