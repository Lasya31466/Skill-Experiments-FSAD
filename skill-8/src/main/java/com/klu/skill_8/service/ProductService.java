package com.klu.skill_8.service;

import com.klu.skill_8.entity.Product;
import com.klu.skill_8.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> getByPriceRange(double min, double max) {
        return productRepository.findByPriceBetween(min, max);
    }

    public List<Product> getSortedByPrice() {
        return productRepository.findAllSortedByPrice();
    }

    public List<Product> getExpensiveProducts(double price) {
        return productRepository.findExpensiveProducts(price);
    }
}