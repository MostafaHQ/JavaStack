package com.mostafa.productsandcategories.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mostafa.productsandcategories.models.Category;
import com.mostafa.productsandcategories.models.Product;
import com.mostafa.productsandcategories.repositories.ProductRepository;

@Service 
public class ProductService {
	
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> allProduct(){
		return productRepository.findAll();	
	}
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}
	
	public List<Product> productsNotOfCategory(Category category){
		return productRepository.findByCategoriesNotContains(category);
	}
	
	
}
