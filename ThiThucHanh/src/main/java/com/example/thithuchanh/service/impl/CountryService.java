package com.example.thithuchanh.service.impl;

import com.example.thithuchanh.model.Country;
import com.example.thithuchanh.repository.CountryRepository;
import com.example.thithuchanh.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService implements ICountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void remove(Long id) {

    }
}
