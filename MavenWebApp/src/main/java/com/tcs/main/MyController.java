package com.tcs.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.main.entity.User;

@Controller
public class MyController {
	
	@GetMapping("/login")
	public ModelAndView handleLogin() {
		ModelAndView obj = new ModelAndView();
		
		obj.setViewName("loginPage");
		
		return obj;
	}
	
	
	@PostMapping("/handleLogin")
	public String authenticate(@ModelAttribute User user) {
		return "profile";
	}
}
