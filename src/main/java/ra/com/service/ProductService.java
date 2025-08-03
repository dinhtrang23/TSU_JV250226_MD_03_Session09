package ra.com.service;



import ra.com.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(String id);
    boolean create(Product product);
    boolean update(Product product);
    boolean delete(String productId);
}
