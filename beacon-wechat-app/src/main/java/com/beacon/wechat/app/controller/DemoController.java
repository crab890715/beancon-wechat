package com.beacon.wechat.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beacon.wechat.api.model.User;
import com.beacon.wechat.api.service.UserService;
@Controller 
@RequestMapping("/demo")
//@Controller
public class DemoController {
	@Autowired
	UserService userService;
	@RequestMapping(value="/demo",method=RequestMethod.GET) 
	public ModelAndView demo() { 
		User u = userService.findUserById(1l);
		ModelAndView view = new ModelAndView("index");
		view.addObject("user", u);
		return view;
	}
}
