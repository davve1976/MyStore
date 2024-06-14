package com.davve.productapi.controller;

import com.davve.productapi.model.Product;
import com.davve.productapi.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@PostMapping
	public void addProduct(@RequestBody Product product) {
		productService.saveProduct(product);
	}

	@PutMapping("/{id}")
	public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
		Product existingProduct = productService.getProductById(id);
		if (existingProduct != null) {
			product.setId(id); // Ensure the correct ID is set
			productService.saveProduct(product);
		}
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}