package com.beacon.wechat.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beacon.wechat.app.biz.DemoBiz;
@Controller 
@RequestMapping("/demo")
//@Controller
public class DemoController {
	@Autowired
	DemoBiz demoBiz;
	@RequestMapping(value="/demo",method=RequestMethod.GET) 
	public ModelAndView demo() { 
		ModelAndView view = new ModelAndView("index");
		view.addObject("username", demoBiz.getName(1l));
		return view;
	}
}
