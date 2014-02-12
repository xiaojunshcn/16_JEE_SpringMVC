package com.joe.springmvc.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@RequestMapping(value="/user/addUser",method=RequestMethod.POST)
	public ModelAndView addUser(){
		
		String result ="this is addUser------";
		return new ModelAndView("/jquery","result",result);
	}
	
	@RequestMapping(value="/user/delUser",method=RequestMethod.GET)
	public ModelAndView delUser(){
		String result ="this is delUser------";
		return new ModelAndView("/jquery","result",result);
	}
	@RequestMapping(value="/user/toUser",method=RequestMethod.GET)
	public ModelAndView toUser(){
		return new ModelAndView("/jquery");
	}
}
