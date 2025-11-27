package com.worldreports.world_reports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.worldreports.world_reports.enitites.City;
import com.worldreports.world_reports.enitites.Country;
import com.worldreports.world_reports.services.WorldService;

import java.util.List;

@Controller
public class WorldController {

	private final WorldService worldService;
	
	@Autowired
	public WorldController(WorldService worldService) {
		this.worldService = worldService;
	}
	
	@GetMapping("/countryListByPopulationDesc")
    public String listCountriesByPopulation(Model model) {
        List<Country> countries = worldService.getAllCountriesByPopulationDesc();
        
        // Add the list to the Model object so the HTML template can access it
        model.addAttribute("countries", countries); 
        
        return "countryListByPopulationDesc"; // This is the name of your HTML template (country-list.html)
    }
	
	@GetMapping("/cityListByPopulationDesc")
    public String listCityByPopulation(Model model) {
        List<City> cities = worldService.getAllCitiesByPopulationDesc();
        
        // Add the list to the Model object so the HTML template can access it
        model.addAttribute("cities", cities); 
        
        return "cityListByPopulationDesc"; // This is the name of your HTML template (country-list.html)
    }
	
	@GetMapping("/capitolCityListByPopulationDesc")
    public String listCapitolCityByPopulation(Model model) {
        List<City> cities = worldService.getAllCitiesByPopulationDesc();
        
        // Add the list to the Model object so the HTML template can access it
        model.addAttribute("cities", cities); 
        
        return "capitalCityListByPopulationDesc"; // This is the name of your HTML template (country-list.html)
    }
	
	@GetMapping("/topNCityList")
    public String topNCityList(
        @RequestParam(value = "topN", defaultValue = "5") Integer topN,
        Model model) {

		List<City> cities = worldService.getTopPopulatedCities(topN);
        // 1. Add data (the Model) to be used by the HTML template		

		model.addAttribute("cities", cities); 
        // 2. Return the view name (Spring Boot will look for "greeting.html" in src/main/resources/templates/)
        return "topNCityList";
    }
}
