package com.mostafa.dojoninja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mostafa.dojoninja.models.Dojo;
import com.mostafa.dojoninja.services.DojoService;

@Controller
public class DojoController {
	
	private final DojoService dojoService;

	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@GetMapping("/")
	public String home() {
		return "redirect:/dojos/new";
	}
	
	@GetMapping("/dojos/new")
	public String index(@ModelAttribute("dojo") Dojo dojo) {
		return "index.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(@valid @ModelAttribute("dojo") Dojo dojo)
	
}
