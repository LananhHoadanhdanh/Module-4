package com.codegym.minitest_1229.controller;

import com.codegym.minitest_1229.model.Category;
import com.codegym.minitest_1229.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Iterable<Category>> findAll() {
        List<Category> categories = (List<Category>) categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } return new ResponseEntity<>(categories, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }
}
