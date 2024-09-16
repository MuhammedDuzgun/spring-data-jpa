package com.demo.spring_data_jpa.repository;

import com.demo.spring_data_jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private IProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("Product2");
        System.out.println(product);
    }

    @Test
    void findByIdOptional() {
        Optional<Product> productOptional = productRepository.findById(99L);
        System.out.println(productOptional);
    }

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> products = productRepository.findByNameOrDescription("Product2", "Product2");
        System.out.println(products);
    }

    @Test
    void findByNameAndDescriptionMethod() {
        List<Product> products = productRepository.findByNameAndDescription("Product2", "Product2 Description");
        System.out.println(products);
    }

    @Test
    void findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("Product2");
        System.out.println(product);
    }

    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(1500));
        System.out.println(products);
    }

    @Test
    void findByPriceLessThanMethod() {
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(1500));
        System.out.println(products);
    }

    @Test
    void findByNameContainingMethod() {
        Product product = productRepository.findByNameContaining("Product2");
        System.out.println(product);
    }

}
