package com.mostafa.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	
	@RequestMapping({"/omikuji","/"})
	public String omikuji() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/omikuji/post", method=RequestMethod.POST)
	public String post(
			@RequestParam(value="number") Integer number,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="type") String type,
			@RequestParam(value="comment") String comment,
			HttpSession session
			) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("type", type);
		session.setAttribute("comment", comment);
		
		return "redirect:/omikuji/show";
	}
	
	@RequestMapping("/omikuji/show")
	public String show() {
		return "show.jsp";
	}
	
}
