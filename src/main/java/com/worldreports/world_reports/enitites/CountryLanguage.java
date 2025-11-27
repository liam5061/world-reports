package com.worldreports.world_reports.enitites;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {

    // --- Enum for IsOfficial column ---
    public enum IsOfficial {
        T, // True
        F  // False
    }
    // --- End Enum ---


    // 1. Use the composite key class
    @EmbeddedId
    private CountryLanguageId id;

    // 2. Map the Foreign Key to Country using the column from the ID class
    // This establishes the relationship from CountryLanguage to Country
    @ManyToOne
    @MapsId("countryCode") // Tells Hibernate that the 'countryCode' field in the ID class is the FK column
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code")
    private Country country;

    // --- End Primary Key Fields ---


    // --- Other Fields ---
    @Enumerated(EnumType.STRING)
    @Column(name = "IsOfficial", columnDefinition = "ENUM('T','F') DEFAULT 'F'", nullable = false)
    private IsOfficial isOfficial;

    @Column(name = "Percentage", precision = 4, scale = 1, columnDefinition = "DECIMAL(4,1) DEFAULT 0.0", nullable = false)
    private BigDecimal percentage;
    // --- End Other Fields ---

    
    // --- Constructors ---
    public CountryLanguage() {
    }

    // --- End Constructors ---


    // --- Getters and Setters ---

    public IsOfficial getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(IsOfficial isOfficial) {
        this.isOfficial = isOfficial;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    // Optional: Getter/Setter for Country relationship if uncommented
    public Country getCountry() {
         return country;
    }

    public void setCountry(Country country) {
         this.country = country;
    }
    // --- End Getters and Setters ---
}
