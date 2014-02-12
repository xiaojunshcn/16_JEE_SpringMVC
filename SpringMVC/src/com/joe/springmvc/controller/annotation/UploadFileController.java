package com.joe.springmvc.controller.annotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@Controller
@RequestMapping("/file")
public class UploadFileController {
	
	@RequestMapping("/upload")
	public String addUser(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request) throws IOException{
		System.out.println("fileName---->" + file.getOriginalFilename());
		
		if(!file.isEmpty()){
			try {
				FileOutputStream os = new FileOutputStream("C:/JavaDevelopment/test/" + new Date().getTime() + file.getOriginalFilename());
				InputStream in = file.getInputStream();
				int b = 0;
				while((b=in.read()) != -1){
					os.write(b);
				}
				os.flush();
				os.close();
				in.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return "/success";
	}
	
	@RequestMapping("/toUpload")
	public String toUpload(){
		return "/upload";	
	}
	
	@RequestMapping("/upload2")
	public String upload2(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		CommonsMultipartResolver multipartResolver  = new CommonsMultipartResolver(request.getSession().getServletContext());
		if(multipartResolver.isMultipart(request)){
			MultipartHttpServletRequest  multiRequest = (MultipartHttpServletRequest)request;
			
			Iterator<String>  iter = multiRequest.getFileNames();
			while(iter.hasNext()){
					MultipartFile file = multiRequest.getFile((String)iter.next());
				if(file != null){
					String fileName = "demoUpload" + file.getOriginalFilename();
					String path = "C:/JavaDevelopment/test/" + fileName;
					
					File localFile = new File(path);
					
					file.transferTo(localFile);
				}
			}
		}
		return "/success";
	}
}