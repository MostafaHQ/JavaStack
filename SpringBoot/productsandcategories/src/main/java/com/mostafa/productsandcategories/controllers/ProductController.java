package com.mostafa.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mostafa.productsandcategories.models.Product;
import com.mostafa.productsandcategories.service.ProductService;

@Controller
public class ProductController {
	
	private final ProductService productService;
	

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	
	@GetMapping("/products/new")
	public String create(@ModelAttribute("product")Product product) {
		return "/product/newproduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String newProduct(@Valid @ModelAttribute("product")Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "/product/newproduct.jsp";
		}else {
			productService.createProduct(product);
			return "redirect:/";
		}
	}
	
	@GetMapping("/products/{id}")
	public String show(@PathVariable("id") Long id , Model model) {
		model.addAttribute("product", productService.findProduct(id));
		return "/product/show.jsp";
	}
	
}
