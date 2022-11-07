package com.mostafa.dojoninja.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mostafa.dojoninja.models.Ninja;


public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	
	List<Ninja> findAll();
	Optional<Ninja> findById(Long id);
	void deleteById(Long id);

}
