package com.mostafa.languages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mostafa.languages.models.Language;
import com.mostafa.languages.services.LangaugeService;


@Controller
public class LanguageController {
	
	private final LangaugeService langaugeService;

	public LanguageController(LangaugeService langaugeService) {
		this.langaugeService = langaugeService;
	}
	
	@GetMapping("/")
	public String home() {
		return "redirect:/languages";
	}
	
	@GetMapping("/languages")
	public String index(@ModelAttribute("language") Language language,Model model) {
		model.addAttribute("languages", langaugeService.allLanguages());
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("languages", langaugeService.allLanguages());
			return "index.jsp";
		}else {
			langaugeService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id")Long id, Model model) {
		Language language = langaugeService.findLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String update(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("language") Language language,BindingResult result) {
		
		if (result.hasErrors()) {
			return "edit.jsp";
		}else {
			langaugeService.updateExpense(language);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language language = langaugeService.findLanguage(id);
		model.addAttribute("language", language);
		return "show.jsp";
	}
	
	@DeleteMapping("/{id}")
    public String deleteLanguage(@PathVariable("id") Long id) {
		langaugeService.delete(id);
        return "redirect:/languages";
    }
}
