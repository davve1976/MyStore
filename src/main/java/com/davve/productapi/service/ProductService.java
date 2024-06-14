package com.davve.productapi.service;

import java.util.List;

import com.davve.productapi.model.Product;

public interface ProductService {

	Product getProductById(Long id);

	List<Product> getAllProducts();

	void saveProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(Long id);
}
