package customer.controller;

import customer.model.Customer;
import customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/create-customer")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/create-customer")
    public String saveCustomer(Model model, Customer customer){
//        customerService.save(customer);
        customerService.insertWithStoredProcedure(customer);
        model.addAttribute("customer", new Customer());
        model.addAttribute("message", "New customer created successfully");
        return "/create";
    }

    @GetMapping("/customers")
    public String showList(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "/list";
    }

    @GetMapping("/edit-customer/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "/edit";
        } else {
            return "/error.404";
        }
    }

    @PostMapping("/edit-customer")
    public String updateCustomer(Model model, Customer customer) {
        customerService.save(customer);
        model.addAttribute("customer", customer);
        model.addAttribute("message", "Customer updated successfully");
        return "/edit";
    }

    @GetMapping("/delete-customer/{id}")
    public String showDeleteForm(Model model, @PathVariable long id){
        Customer customer = customerService.findById(id);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "/delete";
        } else {
            return "/error.404";
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(Model model, Customer customer) {
        customerService.remove(customer.getId());
        model.addAttribute("customer", customer);
        return "redirect:customers";
    }
}
