package com.mostafa.languages.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mostafa.languages.models.Language;


public interface LanguageRepository extends CrudRepository<Language, Long> {
	List<Language> findAll();
	Optional<Language> findById(Long id);
	void deleteById(Long id);
}
