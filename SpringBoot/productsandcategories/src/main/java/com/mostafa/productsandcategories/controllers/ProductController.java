package com.mostafa.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mostafa.productsandcategories.models.CategoryProduct;
import com.mostafa.productsandcategories.models.Product;
import com.mostafa.productsandcategories.service.CategoryProductService;
import com.mostafa.productsandcategories.service.CategoryService;
import com.mostafa.productsandcategories.service.ProductService;

@Controller
public class ProductController {
	
	private final ProductService productService;
	private final CategoryService categoryService;
	private final CategoryProductService categoryProductService;
	

	public ProductController(ProductService productService, CategoryService categoryService,CategoryProductService categoryProductService) {
		this.productService = productService;
		this.categoryService = categoryService;
		this.categoryProductService = categoryProductService;
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
	public String show(@ModelAttribute("categoryProduct")CategoryProduct categoryProduct, @PathVariable("id") Long id , Model model) {
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("categories",categoryService.categoriesNotOfProduct(product));
		return "/product/show.jsp";
	}
	
	@PostMapping("/products/{id}")
	public String addCategoryProduct(@ModelAttribute("categoryProduct")CategoryProduct categoryProduct) {
		categoryProductService.create(categoryProduct);
		return ("redirect:/products/{id}");
	}
	
	
	
}
