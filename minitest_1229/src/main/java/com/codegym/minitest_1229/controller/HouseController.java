package com.codegym.minitest_1229.controller;

import com.codegym.minitest_1229.model.Category;
import com.codegym.minitest_1229.model.House;
import com.codegym.minitest_1229.service.house.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/houses")
public class HouseController {
    @Autowired
    private IHouseService houseService;

    @GetMapping("")
    public ResponseEntity<Iterable<House>> findAll() {
        List<House> houses = (List<House>) houseService.findAll();
        if (houses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<House> save(@RequestBody House house) {
        return new ResponseEntity<>(houseService.save(house), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<House> findById(@PathVariable Long id) {
        Optional<House> houseOptional = houseService.findById(id);
        if (!houseOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houseOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<House> update(@PathVariable Long id, @RequestBody House house) {
        Optional<House> houseOptional = houseService.findById(id);
        if (!houseOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        house.setId(houseOptional.get().getId());
        return new ResponseEntity<>(houseService.save(house), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<House> delete(@PathVariable Long id) {
        Optional<House> houseOptional = houseService.findById(id);
        if (!houseOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        houseService.remove(id);
        return new ResponseEntity<>(houseOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/orderByName")
    public ResponseEntity<Iterable<House>> orderByName() {
        List<House> houses = (List<House>) houseService.orderByName();
        if (houses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping("/bathroomMoreThan2")
    public ResponseEntity<Iterable<House>> findWhereBathroomMoreThan2() {
        List<House> houses = (List<House>) houseService.findWhereBathroomMoreThan2();
        if (houses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping("/findByCategory")
    public ResponseEntity<Iterable<House>> findByCategory(@RequestParam Long id) {
        List<House> houses = (List<House>) houseService.findByCategory(id);
        if (houses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } return new ResponseEntity<>(houses, HttpStatus.OK);
    }
}
