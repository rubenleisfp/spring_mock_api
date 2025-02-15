package com.fp.mockapi.carts.model;

import java.util.Objects;

public class Product {
    private int id;
    private String title;
    private double price;
    private int quantity;
    private double total;
    private double discountPercentage;
    private double discountedTotal;
    private double discountedPrice;
    private String thumbnail;

    public Product() {

    }

    public Product(Integer id, String title, double price, int quantity, double total, double discountPercentage, double discountedTotal, double discountedPrice, String thumbnail) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.discountPercentage = discountPercentage;
        this.discountedTotal = discountedTotal;
        this.discountedPrice = discountedPrice;
        this.thumbnail = thumbnail;
    }


    // Getters y setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountedTotal() {
        return discountedTotal;
    }

    public void setDiscountedTotal(double discountedTotal) {
        this.discountedTotal = discountedTotal;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(price, product.price) == 0 && quantity == product.quantity && Double.compare(total, product.total) == 0 && Double.compare(discountPercentage, product.discountPercentage) == 0 && Double.compare(discountedTotal, product.discountedTotal) == 0 && Double.compare(discountedPrice, product.discountedPrice) == 0 && Objects.equals(title, product.title) && Objects.equals(thumbnail, product.thumbnail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, quantity, total, discountPercentage, discountedTotal, discountedPrice, thumbnail);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", total=" + total +
                ", discountPercentage=" + discountPercentage +
                ", discountedTotal=" + discountedTotal +
                ", discountedPrice=" + discountedPrice +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}