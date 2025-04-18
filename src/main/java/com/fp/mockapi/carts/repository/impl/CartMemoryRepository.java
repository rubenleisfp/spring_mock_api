package com.fp.mockapi.carts.repository.impl;

import com.fp.mockapi.carts.model.Cart;
import com.fp.mockapi.carts.model.CartPage;
import com.fp.mockapi.carts.repository.CartRepository;
import com.fp.mockapi.utils.exceptions.JsonUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CartMemoryRepository implements CartRepository {

    private final CartPage cartPage;

    public CartMemoryRepository() {
        JsonUtils jsonUtils = new JsonUtils();
        cartPage= jsonUtils.getCartPage();

    }

    @Override
    public CartPage getAll() {
        return cartPage;
    }

    /*
    @Override
    public Optional<Cart> getById(int id) {
        return cartPage.getCarts().stream()
                .filter(cart -> cart.getId() == id)
                .findFirst();
    }*/

    @Override
    public CartPage getByUserId(int id) {
        List<Cart> userCarts = cartPage.getCarts().stream()
                .filter(cart -> cart.getUserId() == id)
                .collect(Collectors.toList());
        CartPage result = new CartPage();
        result.setCarts(userCarts);
        result.setTotal(userCarts.size());
        return result;
    }
}