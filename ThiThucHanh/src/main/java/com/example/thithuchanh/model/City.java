package com.example.thithuchanh.model;

import javax.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long area;
    private Long population;
    private Long GDP;
    @ManyToOne
    private Country country;

    public City() {
    }

    public City(Long area, Long population, Long GDP, Country country) {
        this.area = area;
        this.population = population;
        this.GDP = GDP;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getGDP() {
        return GDP;
    }

    public void setGDP(Long GDP) {
        this.GDP = GDP;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
