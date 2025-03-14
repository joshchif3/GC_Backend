package myfiles.GC.repository;

import myfiles.GC.model.Product;
import myfiles.GC.model.ProductCategory;
import myfiles.GC.model.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findByCategory(ProductCategory category);
    List<Product> findByStatus(ProductStatus status);
}
