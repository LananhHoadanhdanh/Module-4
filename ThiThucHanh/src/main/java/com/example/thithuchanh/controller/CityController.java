package com.example.thithuchanh.controller;

import com.example.thithuchanh.model.City;
import com.example.thithuchanh.model.Country;
import com.example.thithuchanh.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private ICityService cityService;

    @GetMapping("")
    public ResponseEntity<Iterable<City>> findAll() {
        List<City> cities = (List<City>) cityService.findAll();
        if (cities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> save(@RequestBody City city) {
        return new ResponseEntity<>(cityService.save(city), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cityOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> update(@PathVariable Long id, @RequestBody City city) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        city.setId(cityOptional.get().getId());
        return new ResponseEntity<>(cityService.save(city), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> delete(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.remove(id);
        return new ResponseEntity<>(cityOptional.get(), HttpStatus.NO_CONTENT);
    }
}
