package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import product.model.Product;
import product.service.ICategoryService;
import product.service.IProductService;

import java.util.ArrayList;

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
        model.addAttribute("products",products);
        return "product/list";
    }
}
