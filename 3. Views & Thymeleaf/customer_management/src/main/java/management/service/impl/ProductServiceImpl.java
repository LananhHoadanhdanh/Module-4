package management.service.impl;

import management.model.Product;
import management.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    List<Product> products;

    public ProductServiceImpl() {
        products = new ArrayList<>();
        products.add(new Product("May tinh", 5000, "May tinh ca nhan", "Apple"));
        Product.count ++;
        products.add(new Product("Xe may", 6000, "Xe tay ga", "Honda Lead"));
        Product.count ++;
        products.add(new Product("O to", 5000, "Xe 4 cho", "Toyota"));
        Product.count ++;
        products.add(new Product("Dien thoai", 5000, "Dien thoai cam ung", "Samsung"));
        Product.count ++;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void save(Product product) {
        products.add(product);
        Product.count ++;
    }

    @Override
    public Product findById(int id) {
        return products.get(findIndexById(id));
    }

    @Override
    public void update(int id, Product product) {
        products.set(findIndexById(id), product);
    }

    @Override
    public void remove(int id) {
        products.remove(findIndexById(id));
    }

    @Override
    public List<Product> findByName(String key) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < this.products.size(); i++) {
            if (this.products.get(i).getName().contains(key)) {
                products.add(this.products.get(i));
            }
        }
        return products;
    }
}
