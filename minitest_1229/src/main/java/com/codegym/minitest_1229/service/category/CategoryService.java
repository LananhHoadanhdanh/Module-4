package com.codegym.minitest_1229.service.category;

import com.codegym.minitest_1229.model.Category;
import com.codegym.minitest_1229.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Category save(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public void remove(Long id) {

    }
}
