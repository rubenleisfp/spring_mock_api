package com.fp.mockapi.products.service;

import com.fp.mockapi.products.model.Product;
import com.fp.mockapi.products.model.ProductPage;
import com.fp.mockapi.products.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductService {

	private static Logger LOG = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepository productRepository;

	public ProductPage getAll() {
		ProductPage productPage = new ProductPage();
		return productRepository.getAll();
	}

	public Optional<Product> getById(int id)	{
		return productRepository.getById(id);
	}
}