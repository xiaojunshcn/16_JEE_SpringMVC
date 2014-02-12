package com.joe.springmvc.controller.annotation;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class SpringContextCheckController {

	@RequestMapping("/springContextCheck/get")
	public String get(HttpServletRequest request){
		//spring的上下文
		WebApplicationContext ac1 = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		//springMVC的上下文
		WebApplicationContext ac2 = RequestContextUtils.getWebApplicationContext(request);
		
		//springManager bean的注入配置是放在spring的上下文里的，测试springMVC上下文也能拿到
		ISpring springManager = (ISpring)ac2.getBean("springManager");
		
		System.out.println(springManager.get());
		return "/success";
	}
}
