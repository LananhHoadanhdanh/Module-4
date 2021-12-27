package com.example.demospringboot.controller;

import com.example.demospringboot.model.Category;
import com.example.demospringboot.model.Product;
import com.example.demospringboot.service.ICategoryService;
import com.example.demospringboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model) {
        Iterable<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/product/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        Iterable<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "/product/create";
    }

    @PostMapping("/create")
    public String createProduct(Product product, RedirectAttributes redirect, @RequestParam MultipartFile img1) {
        String fileName = img1.getOriginalFilename();
        try {
            FileCopyUtils.copy(img1.getBytes(),
                    new File("F:\\Rei\\Code Gym\\Luyen tap\\Module 4\\demoSpringBoot\\src\\main\\resources\\static\\images\\" + fileName)); // coppy ảnh từ ảnh nhận được vào thư mục quy định,
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        product.setImg(fileName);
        productService.save(product);
        redirect.addFlashAttribute("message", "New product created successfully");
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            Iterable<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            return "/product/edit";
        }
        return "/product/404.error";
    }

    @PostMapping("/edit")
    public String editProduct(Product product, RedirectAttributes redirect, @RequestParam MultipartFile img1){
        String fileName = img1.getOriginalFilename();
        try {
            FileCopyUtils.copy(img1.getBytes(),
                    new File("F:\\Rei\\Code Gym\\Luyen tap\\Module 4\\demoSpringBoot\\src\\main\\resources\\static\\images\\" + fileName)); // coppy ảnh từ ảnh nhận được vào thư mục quy định,
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        product.setImg(fileName);
        productService.save(product);
        redirect.addFlashAttribute("message", "Edited product successfully");
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(RedirectAttributes redirect, @PathVariable long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            productService.remove(id);
            redirect.addFlashAttribute("message", "Deleted product successfully");
            return "redirect:/products";
        }
        return "/product/404.error";
    }
}

