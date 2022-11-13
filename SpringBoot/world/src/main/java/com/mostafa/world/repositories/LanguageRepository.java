package com.mostafa.world.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mostafa.world.models.Language;

public interface LanguageRepository extends CrudRepository<Language,Long>{

	@Query(value="SELECT * from languages  where language ='Slovene' Order by percentage desc", nativeQuery=true)
    List<Language> findCountriesByLanguageOrderByPercentageDesc();

//	get all languages in each country with a percentage greater than 89%? Your query should arrange the result by percentage in descending order.
	@Query(value="select lang.* from countries c join languages lang on c.id= lang.country_id where lang.percentage > 89 order by lang.percentage desc", nativeQuery=true)
	List<Language> findLanguagesByLiteracyGT();
	
}
