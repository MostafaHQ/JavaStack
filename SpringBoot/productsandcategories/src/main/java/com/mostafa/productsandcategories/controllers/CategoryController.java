package com.mostafa.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mostafa.productsandcategories.models.Category;
import com.mostafa.productsandcategories.models.CategoryProduct;
import com.mostafa.productsandcategories.models.Product;
import com.mostafa.productsandcategories.service.CategoryProductService;
import com.mostafa.productsandcategories.service.CategoryService;
import com.mostafa.productsandcategories.service.ProductService;

@Controller
public class CategoryController {

	private final CategoryService categoryService;
	private final ProductService productService;
	private final CategoryProductService categoryProductService;

	public CategoryController(CategoryService categoryService, ProductService productService, CategoryProductService categoryProductService) {
		this.categoryService = categoryService;
		this.productService = productService;
		this.categoryProductService = categoryProductService;
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
	
	@GetMapping("/categories/{id}")
	public String show(@ModelAttribute("categoryProduct")CategoryProduct categoryProduct, @PathVariable("id") Long id , Model model) {
		Category category = categoryService.findCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("products",productService.productsNotOfCategory(category));
		return "/category/show.jsp";
	}
	
	@PostMapping("/categories/{id}")
	public String addCategoryProduct(@ModelAttribute("categoryProduct")CategoryProduct categoryProduct) {
		categoryProductService.create(categoryProduct);
		return ("redirect:/categories/{id}");
	}
}
