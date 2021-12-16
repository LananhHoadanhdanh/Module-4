package management.controller;

import management.model.Product;
import management.service.ProductService;
import management.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    ProductService productService = new ProductServiceImpl();

    @GetMapping("")
    public String showList(Model model, @RequestParam(defaultValue = "") String key) {
        List<Product> products = productService.findByName(key);
            if (products.size() == 0) {
                products = productService.findAll();
            }
        model.addAttribute("products",products);
        return "product/index";
    }

    @GetMapping("create")
    public String showCreateForm(Model model){
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/save")
    public String save(Product product){
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "product/edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirect){
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Update customer successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String showDeleteForm(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/delete";
    }

    @PostMapping("/delete")
    public String remove(Product product, RedirectAttributes redirect){
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/view";
    }

}
