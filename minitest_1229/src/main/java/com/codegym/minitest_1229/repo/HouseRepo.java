package com.codegym.minitest_1229.repo;

import com.codegym.minitest_1229.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepo extends JpaRepository<House, Long> {
    @Query("select h from House h order by h.name")
    Iterable<House> orderByName();

    @Query("select h from House h where h.bathroom > 2")
    Iterable<House> findWhereBathroomMoreThan2();

    @Query("select h from House h where h.category.id =: id")
    Iterable<House> findByCategory(@Param("id") Long id);
}
