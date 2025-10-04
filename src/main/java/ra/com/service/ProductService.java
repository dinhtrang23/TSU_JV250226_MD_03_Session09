package ra.com.service;



import ra.com.dto.request.ProductRequestCreateDTO;
import ra.com.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(String id);
    boolean create(ProductRequestCreateDTO productDto);
    boolean update(ProductRequestCreateDTO productDto);
    boolean delete(String productId);
}
