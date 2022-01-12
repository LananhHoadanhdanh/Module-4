package com.example.thithuchanh.repository;

import com.example.thithuchanh.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
