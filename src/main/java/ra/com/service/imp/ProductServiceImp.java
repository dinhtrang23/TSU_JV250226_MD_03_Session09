package ra.com.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.com.dto.request.ProductRequestCreateDTO;
import ra.com.model.Product;
import ra.com.repository.ProductRepository;
import ra.com.service.ProductService;
import ra.com.service.UploadFileService;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UploadFileService uploadFileService;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean create(ProductRequestCreateDTO productDto) {
        String imageUrl = uploadFileService.uploadFile(productDto.getFile());
        Product product = new Product(productDto.getProductId(),
                productDto.getProductName(),
                productDto.getPrice(),
                imageUrl,
                productDto.getCreated(),
                productDto.getCatalog(), true);
        return productRepository.create(product);
    }

    @Override
    public boolean update(ProductRequestCreateDTO productDto) {
        // 1. Lấy product cũ
        Product product = productRepository.findById(productDto.getProductId());
        if (product == null) return false;

        // 2. Update tên, giá, catalog, created
        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setCatalog(productDto.getCatalog());
        product.setCreated(productDto.getCreated());
        product.setStatus(productDto.isStatus());

        // 3. Upload file mới nếu có
        if (productDto.getFile() != null && !productDto.getFile().isEmpty()) {
            String imageUrl = uploadFileService.uploadFile(productDto.getFile());
            product.setImage(imageUrl); // set ảnh mới
        }
        // nếu không có file mới -> giữ ảnh cũ

        return productRepository.update(product);
    }

    @Override
    public boolean delete(String productId) {
        return productRepository.delete(productId);
    }
}
