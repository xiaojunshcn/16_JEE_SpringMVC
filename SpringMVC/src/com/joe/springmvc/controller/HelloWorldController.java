package com.joe.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("-------HelloWorldController.handleRequest()--------");
		
//		String hello = "Joe";
//		//to welcome.jsp
//		return new ModelAndView("/welcome","result",hello);
		
		Map<String,Object> myMap = new HashMap<String, Object>();
		myMap.put("map1", "Big1");
		myMap.put("map2", "大2");
		myMap.put("map3", "広い3");
		
		return new ModelAndView("/welcome","map",myMap);
	}
}