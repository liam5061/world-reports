package com.worldreports.world_reports.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worldreports.world_reports.enitites.City;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

	List<City> findAllByOrderByPopulationDesc();
	
	/**
     * Retrieves all capital cities ordered by population descending.
     * * The query performs an INNER JOIN between City and Country where the 
     * Country's 'capital' field (the ID) matches the City's 'id'.
     */
    @Query("SELECT c FROM City c " + 
           "INNER JOIN Country cy ON c.id = cy.capital " + 
           "ORDER BY c.population DESC")
    List<City> findAllCapitalCitiesOrderByPopulationDesc();
    
    /**
     * Finds cities ordered by population descending. 
     * The limit (N) is applied by the Pageable object.
     */
    List<City> findAllByOrderByPopulationDesc(Pageable pageable);
}
