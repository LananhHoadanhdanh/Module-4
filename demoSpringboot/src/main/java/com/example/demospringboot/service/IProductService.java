package com.example.demospringboot.service;


import com.example.demospringboot.model.Category;
import com.example.demospringboot.model.Product;

public interface IProductService extends IGeneralService<Product>{
    Iterable<Product> findAllByCategoryId(Long id);
    Iterable<Product> findAllByName(String key);
}
