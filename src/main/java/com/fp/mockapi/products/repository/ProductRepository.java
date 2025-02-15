package com.fp.mockapi.products.repository;

import com.fp.mockapi.products.model.Product;
import com.fp.mockapi.products.model.ProductPage;

import java.util.Optional;

public interface ProductRepository {

    ProductPage getAll();

    Optional<Product> getById(int id);
}
