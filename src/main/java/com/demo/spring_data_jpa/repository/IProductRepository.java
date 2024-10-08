package com.demo.spring_data_jpa.repository;

import com.demo.spring_data_jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
    Optional<Product> findById(Long id);
    List<Product> findByNameOrDescription(String name, String description);
    List<Product> findByNameAndDescription(String name, String description);
    Product findDistinctByName(String name);
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);
    Product findByNameContaining(String name);
    List<Product> findByNameLike(String name);
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Product> findByNameIn(List<String> names);
    List<Product> findFirst2ByOrderByNameAsc();
    List<Product> findTop2ByOrderByPriceDesc();
}
