package myfiles.GC.controller;

import myfiles.GC.exception.ResourceNotFoundException;
import myfiles.GC.model.Product;
import myfiles.GC.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = {"https://fgc-wnzg.onrender.com", "https://gloriouscreations.shop/"}, allowCredentials = "true")
@Validated // Enable method-level validation
public class ProductController {

    @Autowired
    private ProductService productService;

    // Retrieve all products (accessible by everyone)
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Save a new product (restricted to ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    // Get a product by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    // Delete a product by its ID (restricted to ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // Update product details (restricted to ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @Valid @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(id, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    // Update stock count for a product (restricted to ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{id}/stock")
    public ResponseEntity<Product> updateStockCount(@PathVariable int id, @RequestParam boolean increaseStock) {
        Product updatedProduct = productService.updateStockCount(id, increaseStock);
        return ResponseEntity.ok(updatedProduct);
    }

    // Save multiple products (restricted to ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/bulk")
    public ResponseEntity<List<Product>> saveProducts(@Valid @RequestBody List<Product> products) {
        List<Product> savedProducts = productService.saveProducts(products);
        return ResponseEntity.ok(savedProducts);
    }
}
