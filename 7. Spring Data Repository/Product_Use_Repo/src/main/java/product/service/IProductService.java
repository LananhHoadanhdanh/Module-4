package product.service;

import product.model.Category;
import product.model.Product;

public interface IProductService extends IGeneralService<Product>{
    Iterable<Product> findAllByCategory(Category category);
    Iterable<Product> findAllByName(String key);
}
