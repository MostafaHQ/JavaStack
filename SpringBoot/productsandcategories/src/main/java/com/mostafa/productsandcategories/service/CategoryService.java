package com.mostafa.productsandcategories.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mostafa.productsandcategories.models.Category;
import com.mostafa.productsandcategories.models.Product;
import com.mostafa.productsandcategories.repositories.CategoryRepository;

@Service 
public class CategoryService {
	
	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> allCategory(){
		return categoryRepository.findAll();	
	}
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		}else {
			return null;
		}
	}
	
	public List<Category> categoriesNotOfProduct(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}
}
