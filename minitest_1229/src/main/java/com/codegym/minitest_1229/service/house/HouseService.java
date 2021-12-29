package com.codegym.minitest_1229.service.house;

import com.codegym.minitest_1229.model.House;
import com.codegym.minitest_1229.repo.HouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HouseService implements IHouseService{
    @Autowired
    private HouseRepo houseRepo;

    @Override
    public Iterable<House> findAll() {
        return houseRepo.findAll();
    }

    @Override
    public Optional<House> findById(Long id) {
        return houseRepo.findById(id);
    }

    @Override
    public House save(House house) {
        return houseRepo.save(house);
    }

    @Override
    public void remove(Long id) {
        houseRepo.deleteById(id);
    }

    @Override
    public Iterable<House> orderByName() {
        return houseRepo.orderByName();
    }

    @Override
    public Iterable<House> findWhereBathroomMoreThan2() {
        return houseRepo.findWhereBathroomMoreThan2();
    }

    @Override
    public Iterable<House> findByCategory(Long id) {
        return houseRepo.findByCategory(id);
    }
}
