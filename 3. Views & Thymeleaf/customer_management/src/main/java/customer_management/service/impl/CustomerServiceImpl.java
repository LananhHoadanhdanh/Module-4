package customer_management.service.impl;

import customer_management.model.Customer;
import customer_management.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    List<Customer> customers;

    public CustomerServiceImpl() {
        customers = new ArrayList<>();
        customers.add(new Customer(1, "Anh", "anh@gmail.com", "HN"));
        customers.add(new Customer(2, "Long","long@gmail.com", "PT"));
        customers.add(new Customer(3, "Duy","duy@gmail.com", "HP"));
        customers.add(new Customer(4, "Khanh","khanh@gmail.com", "DN"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (id == customers.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(findIndexById(id));
    }

    @Override
    public void update(int id, Customer customer) {
        customers.set(findIndexById(id), customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(findIndexById(id));
    }
}
