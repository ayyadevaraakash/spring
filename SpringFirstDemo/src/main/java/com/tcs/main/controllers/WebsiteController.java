package com.tcs.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class WebsiteController {
	
	@GetMapping("/")
	@ResponseBody
	public String getMethodName() {
		return "hello world";
	}
	
	
}
