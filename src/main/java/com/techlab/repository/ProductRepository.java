package com.techlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlab.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
