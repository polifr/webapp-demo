package com.polifr.demo.maven.webapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.polifr.demo.maven.webapp.model.User;
import com.polifr.demo.maven.webapp.repository.UserDao;

@Controller
public class UserListController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/listUsers.html", method = RequestMethod.GET)
	public ModelAndView listUsers() {
		List<User> users = userDao.getAllUsers();
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("users", users);
		return new ModelAndView("listUsersPage", "model", model);
	}
}
