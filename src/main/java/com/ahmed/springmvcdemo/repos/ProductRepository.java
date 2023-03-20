package com.ahmed.springmvcdemo.repos;

import com.ahmed.springmvcdemo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
