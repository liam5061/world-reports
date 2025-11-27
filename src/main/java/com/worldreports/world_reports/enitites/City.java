package com.worldreports.world_reports.enitites;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.util.Objects;

@Entity
@Table(name = "city")
public class City {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Name", length = 35, nullable = false)
    private String name;

    // NOTE: This links to the Country entity based on your foreign key constraint.
    // Assuming a Country entity exists with 'Code' as its primary key.
    @ManyToOne()
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", nullable = false)
    private Country country;

    @Column(name = "District", length = 20, nullable = false)
    private String district;

    @Column(name = "Population", nullable = false)
    private Integer population;

    // --- Constructors ---

    public City() {
        // Default constructor required by JPA
    }
    
 // --- Getters and Setters ---

    public Integer getId() {
        return id;
    }

    // Usually, you don't set an ID directly when using AUTO_INCREMENT
    // public void setId(Integer id) {
    //     this.id = id;
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    // --- Utility Methods (Recommended) ---

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        // Use the business key (or combination of attributes) for equality check
        // if ID is not yet generated, but using ID is safer if available.
        return Objects.equals(id, city.id) &&
               Objects.equals(name, city.name) &&
               Objects.equals(country, city.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }

    @Override
    public String toString() {
        return "City{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", countryCode=" + (country != null ? country.getCode() : "null") + // Assuming Country has a getCode()
               ", district='" + district + '\'' +
               ", population=" + population +
               '}';
    }
}
