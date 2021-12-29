package com.codegym.minitest_1229.service.house;

import com.codegym.minitest_1229.model.House;
import com.codegym.minitest_1229.service.IGeneralService;
import org.springframework.data.repository.query.Param;

public interface IHouseService extends IGeneralService<House> {
    Iterable<House> orderByName();
    Iterable<House> findWhereBathroomMoreThan2();
    Iterable<House> findByCategory(Long id);
}
