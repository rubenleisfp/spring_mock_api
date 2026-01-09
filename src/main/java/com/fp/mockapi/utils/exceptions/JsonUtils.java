package com.fp.mockapi.utils.exceptions;

import com.fp.mockapi.post.model.PostPage;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class JsonUtils {

    private static final String PRODUCT_JSON_FILE_PATH = "json/product.json";
    private static final String CART_JSON_FILE_PATH = "json/cart.json";
    private static final String RECIPE_JSON_FILE_PATH = "json/recipe.json";
    private static final String RECIPE_HIDDEN_JSON_FILE_PATH = "json/recipe_hidden.json";
    private static final String RECIPE_TAGS_FILE_PATH = "json/recipe_tags.json";
    private static final String COMMENT_JSON_FILE_PATH = "json/comment.json";
    private static final String QUOTES_JSON_FILE_PATH = "json/quotes.json";
    private static final String POST_JSON_FILE_PATH = "json/post.json";

    public static void main(String[] args) {
        JsonUtils jsonUtils = new JsonUtils();

    }


    public PostPage getPostPage() {
        return getObjectFromFile(POST_JSON_FILE_PATH, PostPage.class);
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
