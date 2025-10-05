package com.tcs.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tcs.main.entity.User;
import com.tcs.main.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String handleLandingPage() {
		return "index";
	}

	@GetMapping("/redirectToRegister")
	public String handleRedirectToRegister(Model model) {

		User user = new User();
		model.addAttribute(user);

		return "register";
	}

	@GetMapping("/redirectToLogin")
	public String handleRedirectToLogin(Model model) {

		User user = new User();
		model.addAttribute(user);

		return "login";
	}

	@PostMapping("/handleRegister")
	public String handleRegistration(@ModelAttribute User user, Model model) {
		userService.insertStudent(user);
		model.addAttribute("user", new User());
		model.addAttribute("success_message", "Registered Successfully. Now you can login");
		return "login";
	}

	@PostMapping("/handleLogin")
	public String handleLogin(@ModelAttribute User formUser, Model model, HttpSession session) {
		User dbUser = userService.findByEmail(formUser.getEmail());

		if (dbUser == null || !dbUser.getPassword().equals(formUser.getPassword())) {
			model.addAttribute("error_message", "Invalid email or password");
			model.addAttribute("user", new User());
			return "login";
		}

		session.setAttribute("loggedUser", dbUser);
		model.addAttribute("user", dbUser);
		return "profile";
	}

	@GetMapping("/profile")
	public String showProfile(HttpSession session, Model model) {
		User loggedUser = (User) session.getAttribute("loggedUser");
		if (loggedUser == null) {
			return "redirect:/redirectToLogin";
		}
		model.addAttribute("user", loggedUser);
		return "profile";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/redirectToLogin";
	}

}
