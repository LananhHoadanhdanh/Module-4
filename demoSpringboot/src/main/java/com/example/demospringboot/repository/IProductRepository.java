package com.example.demospringboot.repository;

import com.example.demospringboot.model.Category;
import com.example.demospringboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> findAllByCategoryId(Long id);
    Iterable<Product> findAllByName(String key);
}
