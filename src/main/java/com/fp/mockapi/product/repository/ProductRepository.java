package com.fp.mockapi.product.repository;

import com.fp.mockapi.product.model.Product;
import com.fp.mockapi.product.model.ProductPage;

import java.util.Optional;

public interface ProductRepository {

    ProductPage getAll();

    Optional<Product> getById(int id);
}
