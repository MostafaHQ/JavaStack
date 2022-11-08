package com.mostafa.productsandcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mostafa.productsandcategories.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> findAll();
	Optional<Category> findById(Long id);
	void deleteById(Long id);
}
