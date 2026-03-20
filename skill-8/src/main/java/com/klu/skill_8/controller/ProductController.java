package com.klu.skill_8.controller;

import com.klu.skill_8.entity.Product;
import com.klu.skill_8.repository.ProductRepository;
import com.klu.skill_8.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void loadData() {
        productRepository.save(new Product("iPhone 15",     "Electronics",  999.99));
        productRepository.save(new Product("Samsung TV",    "Electronics",  799.49));
        productRepository.save(new Product("Nike Shoes",    "Footwear",      89.99));
        productRepository.save(new Product("Adidas Jacket", "Clothing",     149.99));
        productRepository.save(new Product("MacBook Pro",   "Electronics", 1999.99));
        productRepository.save(new Product("Puma Sneakers", "Footwear",     119.99));
        productRepository.save(new Product("Levi's Jeans",  "Clothing",      59.99));
        productRepository.save(new Product("Dell Monitor",  "Electronics",  399.99));
    }

    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return productService.getByCategory(category);
    }

    @GetMapping("/filter")
    public List<Product> getByPriceRange(
            @RequestParam double min,
            @RequestParam double max) {
        return productService.getByPriceRange(min, max);
    }

    @GetMapping("/sorted")
    public List<Product> getSorted() {
        return productService.getSortedByPrice();
    }

    @GetMapping("/expensive/{price}")
    public List<Product> getExpensive(@PathVariable double price) {
        return productService.getExpensiveProducts(price);
    }
}