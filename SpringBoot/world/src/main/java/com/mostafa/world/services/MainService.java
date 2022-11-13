package com.mostafa.world.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mostafa.world.models.City;
import com.mostafa.world.models.Country;
import com.mostafa.world.models.Language;
import com.mostafa.world.repositories.CityRepository;
import com.mostafa.world.repositories.CountryRepository;
import com.mostafa.world.repositories.LanguageRepository;

@Service
public class MainService {
	private final LanguageRepository languageRepository;
	private final CityRepository cityRepository;
	private final CountryRepository countryRepository;
	
	public MainService(LanguageRepository languageRepository, CityRepository cityRepository, CountryRepository countryRepository) {
		this.languageRepository = languageRepository;
		this.cityRepository = cityRepository;
		this.countryRepository = countryRepository;
	}
	
	
	public List<Country> findCountriesByLanguagePercentDesc(){
		List<Language> initial = languageRepository.findCountriesByLanguageOrderByPercentageDesc();
		List<Country> result= new ArrayList<Country>();
		for(Language x: initial) {
			System.out.println("Language: "+ x.getLanguage() +"/ Percentage: " + x.getPercentage()+" / Country : " + x.getCountry().getName());			
			result.add(x.getCountry());
		}
		return result;
	}

	public List<Object[]> allCountriesByCityCount(){
		List<Object[]> result = countryRepository.allCountriesByCityCount();
		for(Object[] row:result) {
			System.out.println(row[0] + " : " + row[1]);			
		}
		return result;
	}
	

	public List<City> findCitiesInCountryByPop(){
		List<City> result = cityRepository.findCitiesInCountryByPop();
		for(City row: result) {
			System.out.println(row.getPopulation() +" : "+ row.getName());			
		}
		return result;
	}


	public List<Language> findLanguagesByLiteracyGT(){
		List<Language> result = languageRepository.findLanguagesByLiteracyGT();
		for(Language row: result) {
			System.out.println(row.getPercentage() +" : "+ row.getLanguage());			
		}		
		return result;
	}


	public List<Country> countriesLTSurfaceAreaGTPopulation(double area, int population){
		List<Country> result = countryRepository.countriesLTSurfaceAreaGTPopulation();
		for(Country row: result) {
			System.out.println("Population : "+row.getPopulation() +" Surface Area : "+ row.getSurface_area() +" Country : " + row.getName());			
		}		
		return result;
	}

	
	public List<Country> findByGovtFormSurfaceGTLifeExGT(){
		List<Country> result = countryRepository.findByGovtFormSurfaceGTLifeExGT(); 
		System.out.println();
		for(Country row: result) {
			System.out.println(" Country : " + row.getName() + " / Area : "+ row.getSurface_area() +" / Life Expectancy" + row.getLife_expaectancy());			
		}		
		return result;
	}	

	
	public List<City> findCityByDistrict(){
		List<City> result = cityRepository.findCityByDistrict();
		System.out.println("Country : "+ result.get(0).getCountry().getName() );
		for(City row: result) {
			System.out.println(" City : " + row.getName() + " / District" + row.getDistrict());			
		}		
		
		return result;
	}

	
	public 	List<Object[]> countryByRegionCnt(){
		List<Object[]> result = countryRepository.countryByRegionCnt();
		for(Object[] row:result) {
			System.out.println(row[0] +" " + row[1]);					
		}
		return result;
	}

}
