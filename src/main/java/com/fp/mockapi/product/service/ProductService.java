package com.fp.mockapi.product.service;

import com.fp.mockapi.product.model.Product;
import com.fp.mockapi.product.model.ProductPage;
import com.fp.mockapi.product.repository.ProductRepository;
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