package testModule3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import testModule3.model.Category;
import testModule3.model.Product;
import testModule3.service.impl.CategoryServiceImpl;
import testModule3.service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("/")
    public String greeting() {
        return "index";
    }

    @GetMapping("/products")
    public String showList(Model model, @RequestParam(defaultValue = "") String key) {
        List<Product> products = new ArrayList<>();
        if (key == null) {
            products = productService.findAll();
        } else {
            products = productService.findByName(key);
            if (products.size() == 0) {
                products = productService.findAll();
            }
        }
        List<Category> categories = findAllCategory(products);
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "list";
    }

    List<Category> findAllCategory(List<Product> products) {
        List<Category> categories = new ArrayList<>();
        for (Product product : products) {
            categories.add(categoryService.findById(product.getCategoryId()));
        }
        return categories;
    }

    @GetMapping("/edit")
    public String showEditForm(Model model, @RequestParam int id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "edit";
    }

    @PostMapping("/edit")
    public String editProduct(Product product) {
        productService.edit(product);
        return "redirect:/products";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id) {
        productService.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(Product product) {
        productService.add(product);
        return "redirect:/products";
    }


}
