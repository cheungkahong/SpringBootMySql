package com.hong.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hong.app.User;
import com.hong.app.UserService;

@Controller
public class MainController {
	private static final Logger log = 
			LoggerFactory.getLogger(MainController.class);
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userInput() {
		return "NewUser";
	}
	
	
	@GetMapping("/adduser") //an alternative way by using ModelAndView object
	public ModelAndView addUser() {
		ModelAndView modelAndView = new ModelAndView("NewUser");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String createNewUser(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String role =  request.getParameter("role");
		log.info("New user: " + name + ", " + role);
		User newUser = new User(name, role);
		userService.saveUser(newUser);
    	List<User> users = userService.listUsers();
    	model.addAttribute("users", users);
		return "ListUsers";
	}	

	

	
    @RequestMapping("/greeting")
    public String greeting( Model model) {
    	List<User> users = userService.listUsers();
    	model.addAttribute("users", users);

        return "ListUsers"; //the name of the view without .html
 	}
}
