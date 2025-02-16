package com.fp.mockapi.recipes.repository.impl;

import com.fp.mockapi.recipes.model.Recipe;
import com.fp.mockapi.recipes.model.RecipePage;
import com.fp.mockapi.recipes.repository.RecipeRepository;
import com.fp.mockapi.utils.exceptions.JsonUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class RecipeMemoryRepository implements RecipeRepository {

    private final RecipePage recipePage;
    private final RecipePage recipePageHidden;

    public RecipeMemoryRepository() {
        JsonUtils jsonUtils = new JsonUtils();
        recipePage = jsonUtils.getRecipePage();
        recipePageHidden = jsonUtils.getRecipePageHiden();
    }

    @Override
    public RecipePage getAll() {
        return recipePage;
    }

    @Override
    public Optional<Recipe> getById(int id) {
        return recipePage.getRecipes().stream()
                .filter(recipe -> recipe.getId() ==id)
                .findFirst();
    }

    public RecipePage getRecipeByTag(String tag) {
        RecipePage recipePage  = new RecipePage();
        List<Recipe> recipeList = this.recipePageHidden.getRecipes().stream()
                .filter(recipe -> recipe.getTags().contains(tag))
                .collect(Collectors.toList());
        recipePage.setRecipes(recipeList);
        recipePage.setSkip(0);
        recipePage.setTotal(recipeList.size());
        recipePage.setLimit(recipeList.size());
        return recipePage;
    }
}
