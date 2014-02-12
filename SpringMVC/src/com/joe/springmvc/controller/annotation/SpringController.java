package com.joe.springmvc.controller.annotation;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringController {

	@Resource(name="springManager")
	private ISpring springManager;
	
	@RequestMapping("/spring/get")
	public String get(){
		System.out.println(springManager.get());
		return "/success";
	}
}
