package com.joe.springmvc.controller.annotation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.joe.springmvc.vo.User;

@Controller
@RequestMapping("/user/data")
public class DataController {
	@RequestMapping("/addUser")
	public String addUser(User user,HttpServletRequest request){
		request.setAttribute("userName", user.getUserName());
		request.setAttribute("age", user.getAge());
		
		return "/userManager";
	}
	
	@RequestMapping("/addUserJson")
	public void addUserJson(User user,HttpServletRequest request,HttpServletResponse response){
		//{"username":"userName","age","age"}
		String result = "{\"userName\":\" "+ user.getUserName() +" \",\"age\":\" "+ user.getAge()+" \"}";
		PrintWriter out = null;
		response.setContentType("application/json");
		
		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/delUser")
	public String delUser(){
		return "";	
	}
	
	@RequestMapping("/toUser")
	public String toUser(){
		return "/json";	
	}
	
	@RequestMapping("/toUser2")
	public String toUser2(){
		return "/addUser";	
	}
}