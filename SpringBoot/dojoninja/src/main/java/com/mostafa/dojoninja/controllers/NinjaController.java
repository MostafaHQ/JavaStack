package com.mostafa.dojoninja.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mostafa.dojoninja.models.Dojo;
import com.mostafa.dojoninja.models.Ninja;
import com.mostafa.dojoninja.services.DojoService;
import com.mostafa.dojoninja.services.NinjaService;

@Controller
public class NinjaController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;

	public NinjaController(NinjaService ninjaService,DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	@GetMapping("/ninjas/new")
	public String addNinja(@ModelAttribute("ninja") Ninja ninja,Model model) {
		model.addAttribute("dojos",dojoService.allDojo());
		return "ninja.jsp";
	}
	
	@PostMapping("/ninjas/new")
		public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja,BindingResult result, Model model) {
			if (result.hasErrors()) {
				return"ninja.jsp";
			}else {
				ninjaService.createNinja(ninja);
				return "redirect:/ninjas/new";
			}
		}
	@GetMapping("/dojos/{id}")
	public String show(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("ninjas", ninjaService.allNinja());
		return "show.jsp";
	}
	}
