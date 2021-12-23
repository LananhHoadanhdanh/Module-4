package com.example.demospringboot.repo;

import com.example.demospringboot.model.Category;
import com.example.demospringboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> findAllByCategory(Category category);
    Iterable<Product> findAllByName(String key);
}
