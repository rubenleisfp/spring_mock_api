package com.fp.mockapi.utils.exceptions;

import com.fp.mockapi.carts.model.CartPage;
import com.fp.mockapi.product.model.ProductPage;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonUtils {

    private static final String PRODUCT_JSON_FILE_PATH = "src/main/resources/json/product.json";
    private static final String CART_JSON_FILE_PATH = "src/main/resources/json/cart.json";

    public static void main(String[] args) {
        JsonUtils jsonUtils  = new JsonUtils();
        ProductPage productPage = jsonUtils.getProductPage();
        System.out.println(productPage);
    }


    public ProductPage getProductPage() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(PRODUCT_JSON_FILE_PATH)) {
            // convert the JSON data to a Java object
            ProductPage productPage = gson.fromJson(reader, ProductPage.class);
            return productPage;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public CartPage getCartPage() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(CART_JSON_FILE_PATH)) {
            // convert the JSON data to a Java object
            CartPage cartPage = gson.fromJson(reader, CartPage.class);
            return cartPage;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
