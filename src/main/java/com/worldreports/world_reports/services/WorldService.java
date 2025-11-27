package com.worldreports.world_reports.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.worldreports.world_reports.enitites.City;
import com.worldreports.world_reports.enitites.Country;
import com.worldreports.world_reports.repositories.CityRepository;
import com.worldreports.world_reports.repositories.CountryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorldService {
	 // Inject the Repository interface
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    
    @Autowired
    public WorldService(CountryRepository countryRepository, CityRepository cityRepository) {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    /**
     * Fetches all countries from the database and returns only their names.
     * @return A list of all country names.
     */
    public List<String> getAllCountryNames() {
        // 1. findAll() is provided automatically by JpaRepository
        List<Country> countries = countryRepository.findAll();

        // 2. Map the list of Country objects to a list of String (names)
        return countries.stream()
                .map(Country::getName)
                .collect(Collectors.toList());
    }
    
    public List<Country> getAllCountriesByPopulationDesc() {
        // Calls the new method defined in the Repository
        return countryRepository.findAllByOrderByPopulationDesc();
    }   
    
    public List<City> getAllCitiesByPopulationDesc() {
        // Calls the new method defined in the Repository
        return cityRepository.findAllByOrderByPopulationDesc();
    } 
    
    public List<City> getAllCapitolCitiesByPopulationDesc() {
        // Calls the new method defined in the Repository
        return cityRepository.findAllCapitalCitiesOrderByPopulationDesc();
    } 
    
    /**
     * Retrieves the top N most populated cities in the world.
     * @param limitN The number of top cities to retrieve.
     */
    public List<City> getTopPopulatedCities(int limitN) {
        // Create a PageRequest to limit the results to 'limitN' records (page 0, size N)
        Pageable pageable = PageRequest.of(0, limitN);
        
        return cityRepository.findAllByOrderByPopulationDesc(pageable);
    }
}