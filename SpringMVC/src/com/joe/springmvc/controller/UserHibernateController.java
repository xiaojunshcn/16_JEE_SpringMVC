package com.joe.springmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.joe.springmvc.controller.service.IUserManager;
import com.joe.springmvc.vo.User;

@Controller
@RequestMapping("/userHibernate")
public class UserHibernateController {
 
	@Resource(name="userManager")
	private IUserManager userManager;
	
	@RequestMapping("/toAddUser")
	public String toAddUser(){
		return "/addUser";
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user){
		userManager.addUser(user);
		//return "/success";
		return "redirect:/userHibernate/getAllUser";
	}
	
	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request){
		List<User> user = userManager.getAllUser();
		request.setAttribute("user", user);
		return "/userManager2";
	}
	
	@RequestMapping("/delUser")
	public void delUser(String id,HttpServletResponse response){
		String result = "{\"result\":\"error\"}";
		if(userManager.delUser(id)){
			result = "{\"result\":\"success\"}";
		}
		PrintWriter out = null;
		response.setContentType("application/json");
		
		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getUser")
	public String getUser(String id,HttpServletRequest request){
		User user = userManager.getUser(id);
		
		request.setAttribute("user", user);
		return "/editUser";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(User user,HttpServletRequest request){
		
		if(userManager.updateUser(user)){
			user = userManager.getUser(user.getId());
			request.setAttribute("user", user);
			return "/editUser";
		}else{
			return "/error";
		}
		
	}
}