package com.worldreports.world_reports.repositories.conventers;

import jakarta.persistence.AttributeConverter;
import java.util.stream.Stream;

import com.worldreports.world_reports.enitites.Continent;

public class ContinentConventer implements AttributeConverter<Continent, String>{
	
	// Converts the Java Enum (Continent) to the Database Column (String)
    @Override
    public String convertToDatabaseColumn(Continent continent) {
        if (continent == null) {
            return null;
        }
        // Save the friendly string to the DB (e.g., "North America")
        return continent.getDisplayName(); 
    }

    // Converts the Database Column (String) to the Java Enum (Continent)
    @Override
    public Continent convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        
        // Find the matching enum constant based on the displayName
        return Stream.of(Continent.values())
          .filter(c -> c.getDisplayName().equals(dbData))
          .findFirst()
          .orElseThrow(() -> new IllegalArgumentException("Unknown continent: " + dbData));
    }
}
