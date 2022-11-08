package com.mostafa.productsandcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mostafa.productsandcategories.models.Category;
import com.mostafa.productsandcategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> findAll();
	Optional<Category> findById(Long id);
	void deleteById(Long id);
    List<Category> findByProductsNotContains(Product product);
}
