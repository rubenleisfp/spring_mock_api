package com.fp.mockapi.utils.exceptions;

import com.fp.mockapi.carts.model.CartPage;
import com.fp.mockapi.products.model.ProductPage;
import com.fp.mockapi.recipes.model.RecipePage;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class JsonUtils {

    private static final String PRODUCT_JSON_FILE_PATH = "src/main/resources/json/product.json";
    private static final String CART_JSON_FILE_PATH = "src/main/resources/json/cart.json";
    private static final String RECIPE_JSON_FILE_PATH = "src/main/resources/json/recipe.json";
    private static final String RECIPE_HIDDEN_JSON_FILE_PATH = "src/main/resources/json/recipe_hidden.json";
    private static final String RECIPE_TAGS_FILE_PATH = "src/main/resources/json/recipe_tags.json";


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

    public RecipePage getRecipePage() {
        return getRecipePageFromFile(RECIPE_JSON_FILE_PATH);
    }

    public RecipePage getRecipePageHiden() {
        return getRecipePageFromFile(RECIPE_HIDDEN_JSON_FILE_PATH);
    }

    private RecipePage getRecipePageFromFile(String filePath) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(filePath)) {
            // convert the JSON data to a Java object
            RecipePage recipePage = gson.fromJson(reader, RecipePage.class);
            return recipePage;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getRecipeTagsFromFile() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(RECIPE_TAGS_FILE_PATH)) {
            // convert the JSON data to a Java object
            List<String> recipeTags = gson.fromJson(reader, List.class);
            return recipeTags;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
