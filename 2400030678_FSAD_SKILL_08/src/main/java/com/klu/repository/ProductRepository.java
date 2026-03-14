package com.klu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klu.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min,double max);

    @Query("select p from Product p order by p.price")
    List<Product> sortByPrice();

    @Query("select p from Product p where p.price > ?1")
    List<Product> expensiveProducts(double price);

    @Query("select p from Product p where p.category = ?1")
    List<Product> getByCategory(String category);
}