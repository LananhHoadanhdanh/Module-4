package com.example.demospringboot.service.impl;

import com.example.demospringboot.model.Category;
import com.example.demospringboot.model.Product;
import com.example.demospringboot.repository.IProductRepository;
import com.example.demospringboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> findAllByCategoryId(Long id) {
        return productRepository.findAllByCategoryId(id);
    }

    @Override
    public Iterable<Product> findAllByName(String key) {
        return productRepository.findAllByName(key);
    }
}
