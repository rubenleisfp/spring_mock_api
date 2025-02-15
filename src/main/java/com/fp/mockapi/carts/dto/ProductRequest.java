package com.fp.mockapi.carts.dto;

import java.util.Objects;

public class ProductRequest {
    private int id;
    private int quantity;

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRequest that = (ProductRequest) o;
        return id == that.id && quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}