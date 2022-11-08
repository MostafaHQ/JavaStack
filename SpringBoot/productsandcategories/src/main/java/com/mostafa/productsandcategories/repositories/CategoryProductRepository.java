package com.mostafa.productsandcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mostafa.productsandcategories.models.CategoryProduct;

@Repository
public interface CategoryProductRepository extends CrudRepository<CategoryProduct,Long> {
	public List<CategoryProduct> findAll();
	public Optional<CategoryProduct> findById(Long id);
	public void deleteById(Long id);
	
}
