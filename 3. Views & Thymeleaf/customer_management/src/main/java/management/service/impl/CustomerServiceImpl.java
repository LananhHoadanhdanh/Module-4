package management.service.impl;

import management.model.Customer;
import management.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    List<Customer> customers;

    public CustomerServiceImpl() {
        customers = new ArrayList<>();
        customers.add(new Customer("Anh", "anh@gmail.com", "HN"));
        Customer.count++;
        customers.add(new Customer("Long","long@gmail.com", "PT"));
        Customer.count++;
        customers.add(new Customer("Duy","duy@gmail.com", "HP"));
        Customer.count++;
        customers.add(new Customer("Khanh","khanh@gmail.com", "DN"));
        Customer.count++;
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
        Customer.count++;
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
