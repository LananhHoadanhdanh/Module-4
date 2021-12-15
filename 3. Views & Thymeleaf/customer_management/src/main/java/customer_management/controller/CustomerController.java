package customer_management.controller;

import customer_management.model.Customer;
import customer_management.service.CustomerService;
import customer_management.service.impl.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    CustomerService customerService = new CustomerServiceImpl();

    @GetMapping("")
    public String showList(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "index";
    }

}
