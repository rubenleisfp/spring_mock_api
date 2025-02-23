package com.fp.mockapi.utils.exceptions;


import com.fp.mockapi.products.model.ProductPage;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class JsonUtils {

    private static final String PRODUCT_JSON_FILE_PATH = "json/product.json";
    private static final String CART_JSON_FILE_PATH = "json/cart.json";
    private static final String RECIPE_JSON_FILE_PATH = "json/recipe.json";
    private static final String RECIPE_HIDDEN_JSON_FILE_PATH = "json/recipe_hidden.json";
    private static final String RECIPE_TAGS_FILE_PATH = "json/recipe_tags.json";

    public static void main(String[] args) {
        JsonUtils jsonUtils = new JsonUtils();
        ProductPage productPage = jsonUtils.getProductPage();
        System.out.println(productPage);
    }

    public ProductPage getProductPage() {
        return getObjectFromFile(PRODUCT_JSON_FILE_PATH, ProductPage.class);
    }

    public List<String> getRecipeTagsFromFile() {
        return getObjectFromFile(RECIPE_TAGS_FILE_PATH, List.class);
    }

    private <T> T getObjectFromFile(String filePath, Class<T> clazz) {
        Gson gson = new Gson();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            if (inputStream == null) {
                throw new RuntimeException("No se pudo encontrar el archivo: " + filePath);
            }
            try (Reader reader = new InputStreamReader(inputStream)) {
                return gson.fromJson(reader, clazz);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo JSON: " + filePath, e);
        }
    }
}
