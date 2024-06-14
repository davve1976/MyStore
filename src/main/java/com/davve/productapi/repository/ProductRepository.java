package com.davve.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davve.productapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}