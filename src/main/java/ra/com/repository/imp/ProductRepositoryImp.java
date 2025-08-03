package ra.com.repository.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.com.model.Product;
import ra.com.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductRepositoryImp implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("from Product ", Product.class).getResultList();
    }

    @Override
    public Product findById(String productId) {
        return entityManager.createQuery("from Product where productId = :id", Product.class)
                .setParameter("id", productId).getSingleResult();
    }

    @Override
    @Transactional
    public boolean create(Product product) {
        try {
            product.setProductId(generateProductId());
            entityManager.persist(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private String generateProductId() {
        try {
            String lastId = entityManager.createQuery(
                    "SELECT p.productId FROM Product p ORDER BY p.productId DESC",
                    String.class
            ).setMaxResults(1).getSingleResult();

            int number = Integer.parseInt(lastId.substring(1));
            return String.format("P%04d", number + 1);
        } catch (NoResultException e) {
            // Bảng rỗng
            return "P0001";
        }
    }

    @Override
    @Transactional
    public boolean update(Product product) {
        try {
            entityManager.merge(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        return false;
        }
    }

    @Override
    @Transactional
    public boolean delete(String productId) {
        try {
            Product product = findById(productId);
            entityManager.remove(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
