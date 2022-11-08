package com.mostafa.productsandcategories.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mostafa.productsandcategories.service.CategoryService;
import com.mostafa.productsandcategories.service.ProductService;

@Controller
public class MainController {
	
	private final ProductService productService;
	private final CategoryService categorytService;
	
	
	
	public MainController(ProductService productService, CategoryService categorytService) {
		this.productService = productService;
		this.categorytService = categorytService;
	}



	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("products", productService.allProduct());
		model.addAttribute("categories", categorytService.allCategory());
		return "index.jsp";
	}
	
}
