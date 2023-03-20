package com.ahmed.springmvcdemo.controllers;

import com.ahmed.springmvcdemo.entities.Product;
import com.ahmed.springmvcdemo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createProduct";
    }

    @RequestMapping("/saveProduct")
    public String saveProduct(
            @ModelAttribute("product") Product product,
            @RequestParam("creationDate") String date,
            ModelMap modelMap) throws ParseException {
        // Convert the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date creationDate = dateFormat.parse(String.valueOf(date));
        product.setCreatedAt(creationDate);

        Product savedProduct = productService.saveProduct(product);
        String msg = "Product saved with ID: " + savedProduct.getProductId();
        modelMap.addAttribute("msg", msg);
        return "createProduct";
    }

    @RequestMapping("/listProducts")
    public String listProducts(
            ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size
    ) {
        Page<Product> products = productService.getAllProductsByPage(page, size);
        modelMap.addAttribute("products", products);
        modelMap.addAttribute("pages", new int[products.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listProducts";
    }

    @RequestMapping("/deleteProduct")
    public String deleteProduct(
            @RequestParam("productId") Long id,
            ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size
    ) {
        productService.deleteProductById(id);
        Page<Product> products = productService.getAllProductsByPage(page, size);
        modelMap.addAttribute("products", products);
        modelMap.addAttribute("pages", new int[products.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listProducts";
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(@RequestParam("productId") Long id, ModelMap modelMap) {
        Product product = productService.getProduct(id);
        modelMap.addAttribute("product", product);
        return "updateProduct";
    }

    @RequestMapping("/updateProduct")
    public String updateProduct(
            @ModelAttribute("product") Product product,
            @RequestParam("creationDate") String date,
            ModelMap modelMap) throws ParseException {
        // Convert the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date creationDate = dateFormat.parse(String.valueOf(date));
        product.setCreatedAt(creationDate);

        productService.updateProduct(product);
        Iterable<Product> products = productService.getAllProducts();
        modelMap.addAttribute("products", products);
        return "listProducts";
    }
}
