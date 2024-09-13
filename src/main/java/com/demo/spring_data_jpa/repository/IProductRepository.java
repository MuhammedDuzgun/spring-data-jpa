package com.demo.spring_data_jpa.repository;

import com.demo.spring_data_jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
