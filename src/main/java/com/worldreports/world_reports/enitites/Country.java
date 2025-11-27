package com.worldreports.world_reports.enitites;

import jakarta.persistence.*;
import java.math.BigDecimal; // For decimal types
import java.util.HashSet;
import java.util.Set;

import com.worldreports.world_reports.repositories.conventers.*;


@Entity
@Table(name = "country")
public class Country {
	  // Primary Key mapping
	// --- Primary Key ---
    @Id
    @Column(name = "Code", length = 3, nullable = false)
    private String code; // char(3) -> String
    
    // FK keys
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<City> cities = new HashSet<>();
    
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<CountryLanguage> countryLanguage = new HashSet<>();
    // --- Other Fields ---
    
    @Column(name = "Name", length = 52, nullable = false)
    private String name; // char(52) -> String

    //@Enumerated(EnumType.STRING) // Tells JPA to store the enum name as a String
    @Convert(converter = ContinentConventer.class)
    @Column(name = "Continent", nullable = false)
    private Continent continent; // enum(...) -> Continent Enum

    @Column(name = "Region", length = 26, nullable = false)
    private String region; // char(26) -> String

    @Column(name = "SurfaceArea", precision = 10, scale = 2, nullable = false)
    private BigDecimal surfaceArea; // decimal(10,2) -> BigDecimal

    @Column(name = "IndepYear")
    private Short indepYear; // smallint -> Short (allows NULL)

    @Column(name = "Population", nullable = false)
    private Integer population; // int -> Integer

    @Column(name = "LifeExpectancy", precision = 3, scale = 1)
    private BigDecimal lifeExpectancy; // decimal(3,1) -> BigDecimal (allows NULL)

    @Column(name = "GNP", precision = 10, scale = 2)
    private BigDecimal gnp; // decimal(10,2) -> BigDecimal (allows NULL)

    @Column(name = "GNPOld", precision = 10, scale = 2)
    private BigDecimal gnpOld; // decimal(10,2) -> BigDecimal (allows NULL)

    @Column(name = "LocalName", length = 45, nullable = false)
    private String localName; // char(45) -> String

    @Column(name = "GovernmentForm", length = 45, nullable = false)
    private String governmentForm; // char(45) -> String

    @Column(name = "HeadOfState", length = 60)
    private String headOfState; // char(60) -> String (allows NULL)

    // Note: If you have a City entity, this should be a @OneToOne or @ManyToOne relationship
    // For simplicity and matching the script's column type, it's just an Integer here.
    @Column(name = "Capital")
    private Integer capital; // int -> Integer (allows NULL)

    @Column(name = "Code2", length = 2, nullable = false)
    private String code2; // char(2) -> String
    
    // --- Constructors ---

    public Country() {
    }

 // --- Getters and Setters ---

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BigDecimal getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(BigDecimal surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Short getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(Short indepYear) {
        this.indepYear = indepYear;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public BigDecimal getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(BigDecimal lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public BigDecimal getGnp() {
        return gnp;
    }

    public void setGnp(BigDecimal gnp) {
        this.gnp = gnp;
    }

    public BigDecimal getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(BigDecimal gnpOld) {
        this.gnpOld = gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }
}

