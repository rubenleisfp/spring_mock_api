package com.fp.mockapi.utils.exceptions;

import com.fp.mockapi.carts.model.CartPage;
import com.fp.mockapi.comments.model.CommentPage;
import com.fp.mockapi.post.model.PostPage;
import com.fp.mockapi.products.model.ProductPage;
import com.fp.mockapi.quotes.model.QuotePage;
import com.fp.mockapi.recipes.model.RecipePage;
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
    private static final String COMMENT_JSON_FILE_PATH = "json/comment.json";
    private static final String QUOTES_JSON_FILE_PATH = "json/quotes.json";
    private static final String POST_JSON_FILE_PATH = "json/post.json";

    public static void main(String[] args) {
        JsonUtils jsonUtils = new JsonUtils();
        ProductPage productPage = jsonUtils.getProductPage();
        System.out.println(productPage);
    }

    public ProductPage getProductPage() {
        return getObjectFromFile(PRODUCT_JSON_FILE_PATH, ProductPage.class);
    }

    public CartPage getCartPage() {
        return getObjectFromFile(CART_JSON_FILE_PATH, CartPage.class);
    }

    public RecipePage getRecipePage() {
        return getObjectFromFile(RECIPE_JSON_FILE_PATH, RecipePage.class);
    }

    public RecipePage getRecipePageHidden() {
        return getObjectFromFile(RECIPE_HIDDEN_JSON_FILE_PATH, RecipePage.class);
    }

    public CommentPage getCommentPage() {
        return getObjectFromFile(COMMENT_JSON_FILE_PATH, CommentPage.class);
    }
    public PostPage getPostPage() {
        return getObjectFromFile(POST_JSON_FILE_PATH, PostPage.class);
    }

    public QuotePage getQuotesPage() {
        return getObjectFromFile(QUOTES_JSON_FILE_PATH, QuotePage.class);
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
