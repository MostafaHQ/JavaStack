package com.mostafa.world.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mostafa.world.services.MainService;

@Controller
public class MainController {
	
	private final MainService mainService;

	public MainController(MainService mainService) {
		this.mainService = mainService;
	}

	@RequestMapping("/")
	public String index() {


		mainService.findCountriesByLanguagePercentDesc();


		mainService.allCountriesByCityCount();


		mainService.findCitiesInCountryByPop();

		
		mainService.findLanguagesByLiteracyGT();


		mainService.countriesLTSurfaceAreaGTPopulation(0, 0);


		mainService.findByGovtFormSurfaceGTLifeExGT();


		mainService.findCityByDistrict();


		mainService.countryByRegionCnt();
		
		return "index";
	}
}
