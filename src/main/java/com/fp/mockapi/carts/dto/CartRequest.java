package com.fp.mockapi.carts.dto;

import java.util.List;
import java.util.Objects;

public class CartRequest {
    private int userId;
    private List<ProductRequest> products;

    // Getters y setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public List<ProductRequest> getProducts() { return products; }
    public void setProducts(List<ProductRequest> products) { this.products = products; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartRequest that = (CartRequest) o;
        return userId == that.userId && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, products);
    }

    @Override
    public String toString() {
        return "CartRequest{" +
                "userId=" + userId +
                ", products=" + products +
                '}';
    }
}
