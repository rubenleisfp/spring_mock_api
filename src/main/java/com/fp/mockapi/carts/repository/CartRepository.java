package com.fp.mockapi.carts.repository;

import com.fp.mockapi.carts.model.Cart;
import com.fp.mockapi.carts.model.CartPage;
import com.fp.mockapi.product.model.Product;
import com.fp.mockapi.product.model.ProductPage;

import java.util.Optional;

public interface CartRepository {

    CartPage getAll();

    Optional<Cart> getById(int id);

    CartPage getByUserId(int id);
}
