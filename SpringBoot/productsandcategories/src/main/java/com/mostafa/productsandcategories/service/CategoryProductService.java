package com.mostafa.productsandcategories.service;

import org.springframework.stereotype.Service;
import com.mostafa.productsandcategories.models.CategoryProduct;
import com.mostafa.productsandcategories.repositories.CategoryProductRepository;

@Service 
public class CategoryProductService {
	
	private final CategoryProductRepository categoryProductRepository;

	public CategoryProductService(CategoryProductRepository categoryProductRepository) {
		this.categoryProductRepository = categoryProductRepository;
	}
	
	public CategoryProduct create(CategoryProduct categoryProduct) {
		return categoryProductRepository.save(categoryProduct);
	}
	

}
