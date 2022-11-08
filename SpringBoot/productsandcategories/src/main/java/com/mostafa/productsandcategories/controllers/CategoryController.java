package com.mostafa.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mostafa.productsandcategories.models.Category;
import com.mostafa.productsandcategories.service.CategoryService;

@Controller
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("/categories/new")
	public String create(@ModelAttribute("category") Category category) {
		return "/category/newcategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String newCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "/category/newcategory.jsp";
		}else {
			categoryService.createCategory(category);
			return "redirect:/";
		}
	}
}
