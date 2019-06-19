package com.xime.bupho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xime.bupho.service.PhotoService;
import com.xime.bupho.service.UserService;

@Controller
public class BuphoController {

	  private final UserService userService;
	  private final PhotoService photoService;
	  
	  @Autowired
	  public BuphoController(UserService userService, PhotoService photoService) {   
	    this.userService = userService;
	    this.photoService = photoService;    
	  }

	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public String home(Model model) {
		model.addAttribute("users", this.userService.findAll());	
		model.addAttribute("photos", this.photoService.findAll());
	    return "story/welcome";
	  }
}
