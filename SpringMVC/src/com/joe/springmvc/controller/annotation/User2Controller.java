package com.joe.springmvc.controller.annotation;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user2")
public class User2Controller {
	
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request){
		
		String result ="this is addUser------优化版";
		request.setAttribute("result", result);
		return "/jquery";
	}
	
	@RequestMapping("/delUser")
	public String delUser(HttpServletRequest request){
		String result ="this is delUser------优化版";
		request.setAttribute("result", result);
		return "/jquery";
	}
	@RequestMapping("/toUser")
	public String toUser(HttpServletRequest request){
		String result ="this is toUser------优化版";
		request.setAttribute("result", result);
		return "/jquery";
	}
}
