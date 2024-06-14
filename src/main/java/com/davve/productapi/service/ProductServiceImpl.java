package com.davve.productapi.service;

import com.davve.productapi.model.Product;
import com.davve.productapi.repository.ProductRepository;
import com.davve.productapi.util.FakeStoreResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	private final ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product getProductById(Long id) {
		// to be implemented....get from database
		Optional<Product> optionalProduct = productRepository.findById(id);
		return optionalProduct.orElse(getProductByIdFromFakeStore(getAllProductsFromFakeStore(), id));
	}

	@Override
	public List<Product> getAllProducts() {
		// to be implemented....get from database
		List<Product> optionalProduct = productRepository.findAll();
		return !optionalProduct.isEmpty() ? optionalProduct : getAllProductsFromFakeStore();
	}

	private Product getProductByIdFromFakeStore(List<Product> products, Long id) {
		return FakeStoreResource.getProductById(products, id);
	}

	private List<Product> getAllProductsFromFakeStore() {
		try {
			return FakeStoreResource.getAllProducts();
		} catch (URISyntaxException e) {
			LOGGER.error("Unable to get all products", e);
		}
		return Collections.emptyList();
	}

	@Override
	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
