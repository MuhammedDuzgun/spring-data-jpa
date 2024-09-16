package com.demo.spring_data_jpa.repository;

import com.demo.spring_data_jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class IProductRepositoryTest {

    @Autowired
    private IProductRepository productRepository;

    @Test
    void saveProduct() {
        //create product
        Product product = new Product();
        product.setName("Product1");
        product.setDescription("Product1 Description");
        product.setSku("120abc");
        product.setPrice(new BigDecimal(1000));
        product.setActive(true);
        product.setImageUrl("product1.jpg");

        //save product
        Product savedProduct = productRepository.save(product);

        //display product info
        System.out.println(savedProduct);
    }

    @Test
    void updateProduct() {
        Product productToUpdate = productRepository.findById(1L).get();
        productToUpdate.setName("Product1 - updated");
        productRepository.save(productToUpdate);
    }

    @Test
    void getProductById() {
        Product product = productRepository.findById(1L).get();
        System.out.println(product);
    }

    @Test
    void saveAllProduct() {
        Product product2 = new Product();
        product2.setName("Product2");
        product2.setDescription("Product2 Description");
        product2.setSku("120abcd");
        product2.setPrice(new BigDecimal(2000));
        product2.setActive(true);
        product2.setImageUrl("product3.jpg");

        Product product3 = new Product();
        product3.setName("Product3");
        product3.setDescription("Product3 Description");
        product3.setSku("120abcde");
        product3.setPrice(new BigDecimal(3000));
        product3.setActive(true);
        product3.setImageUrl("product3.jpg");

        productRepository.saveAll(List.of(product2, product3));
    }

    @Test
    void getAllProducts() {
        List<Product> products = productRepository.findAll();
        products.forEach(System.out::println);
    }

    @Test
    void coundProducts() {
        long count = productRepository.count();
        System.out.println("Total products in DB: " + count);
    }

    @Test
    void isProductExists() {
        boolean state = productRepository.existsById(1L);
        System.out.println(state);
    }

}