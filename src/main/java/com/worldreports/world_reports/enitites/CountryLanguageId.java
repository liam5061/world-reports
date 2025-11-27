package com.worldreports.world_reports.enitites;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;

@Embeddable
public class CountryLanguageId implements Serializable {

	@Column(name = "CountryCode", length = 3)
    private String countryCode;
	
	@Column(name = "Language", length = 30)
    private String language;

    // --- Default Constructor (Required by JPA) ---
    public CountryLanguageId() {
    }

    // --- Constructor ---
    public CountryLanguageId(String countryCode, String language) {
        this.countryCode = countryCode;
        this.language = language;
    }

    // --- Must implement equals() and hashCode() ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguageId that = (CountryLanguageId) o;
        return Objects.equals(countryCode, that.countryCode) &&
               Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, language);
    }
    
    // --- Getters and Setters (Optional but good practice) ---
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
