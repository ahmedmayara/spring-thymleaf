package com.ahmed.springmvcdemo;

import com.ahmed.springmvcdemo.entities.Product;
import com.ahmed.springmvcdemo.repos.ProductRepository;
import com.ahmed.springmvcdemo.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Date;

@SpringBootTest
class SpringMvcDemoApplicationTests {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @Test
    public void createProductTest() {
        Product product = new Product("Razer Headset", 500.0, new Date());
        productRepository.save(product);
    }

    @Test
    public void findProductTest() {
        Product product = productRepository.findById(1L).get();
        System.out.println(product);
    }

    @Test
    public void updateProductTest() {
        Product product = productRepository.findById(1L).get();
        product.setProductPrice(1000.0);
        productRepository.save(product);
    }

    @Test
    public void deleteProductTest() {
        productRepository.deleteById(1L);
    }

    @Test
    public void listProductsTest() {
        Iterable<Product> products = productRepository.findAll();
        products.forEach(System.out::println);
    }

    @Test
    public void findProductByNameTest() {
        Page<Product> products = productService.getAllProductsByPage(0, 2);
        System.out.println(products.getSize());
        System.out.println(products.getTotalElements());
        System.out.println(products.getTotalPages());
        products.getContent().forEach(System.out::println);
    }
}
