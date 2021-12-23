package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product.model.Category;
import product.model.Product;
import product.service.ICategoryService;
import product.service.IProductService;

import java.util.ArrayList;
import java.util.Iterator;
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
        return "product/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        Iterable<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "product/create";
    }

    @PostMapping("/create")
    public String createProduct(Product product, RedirectAttributes redirect) {
        productService.save(product);
//        model.addAttribute("product", new Product());
        redirect.addFlashAttribute("message", "New customer created successfully");
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            Iterable<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            return "product/edit";
        }
        return "product/404.error";
    }

    @PostMapping("/edit")
    public String editProduct(Product product, RedirectAttributes redirect){
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
        return "product/404.error";
    }
}

