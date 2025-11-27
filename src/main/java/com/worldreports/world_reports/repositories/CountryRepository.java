package com.worldreports.world_reports.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worldreports.world_reports.enitites.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    
	List<Country> findAllByOrderByPopulationDesc();
	
}
