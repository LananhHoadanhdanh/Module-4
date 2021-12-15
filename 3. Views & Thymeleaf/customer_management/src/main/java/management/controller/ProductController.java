package management.controller;

import management.model.Product;
import management.service.ProductService;
import management.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    ProductService productService = new ProductServiceImpl();

    @GetMapping("")
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
        model.addAttribute("products",products);
        return "product/index";
    }

    @GetMapping("create")
    public String showCreateForm(Model model){
        model.addAttribute("product", new Product());
        return "product/create";
    }
}
