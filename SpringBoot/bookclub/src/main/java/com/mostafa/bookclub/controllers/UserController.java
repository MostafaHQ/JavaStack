package com.mostafa.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mostafa.bookclub.models.LoginUser;
import com.mostafa.bookclub.models.User;
import com.mostafa.bookclub.services.UserService;

@Controller
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			return "redirect:/books";
		}else {
			model.addAttribute("newUser", new User());
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
	}
	
	 @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		 User registeredUser = userService.register(newUser, result);
		 if(result.hasErrors()) {
			 model.addAttribute("newLogin", new LoginUser());
			 return "index.jsp";
		 }else {
			 session.setAttribute("userId", registeredUser.getId());
			 return "redirect:/books";
		 }
	 }
	 
	 @PostMapping("/login")
	 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		 User user = userService.login(newLogin, result);
		 if(result.hasErrors()) {
			 model.addAttribute("newUser", new User());
			 return "index.jsp";
		 }
		 session.setAttribute("userId", user.getId());
			 return "redirect:/books";
		 }
	
	@GetMapping("/logout")
		public String logOut(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
	}

