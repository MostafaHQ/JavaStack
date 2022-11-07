package com.mostafa.languages.controllers;

import org.springframework.stereotype.Controller;

import com.mostafa.languages.services.LangaugeService;

@Controller
public class LanguageController {
	
	private final LangaugeService langaugeService;

	public LanguageController(LangaugeService langaugeService) {
		this.langaugeService = langaugeService;
	}
	
	
}
