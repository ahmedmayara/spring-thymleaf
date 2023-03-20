package com.ahmed.springmvcdemo.services;

import com.ahmed.springmvcdemo.entities.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Product product);
    void deleteProductById(Long id);
    Product getProduct(Long id);
    List<Product> getAllProducts();
    Page<Product> getAllProductsByPage(int page, int size);
}
