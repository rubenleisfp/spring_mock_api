package com.fp.mockapi.recipes.repository;

import com.fp.mockapi.recipes.model.Recipe;
import com.fp.mockapi.recipes.model.RecipePage;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository {

    RecipePage getAll();

    Optional<Recipe> getById(int id);

    RecipePage getByTag(String tag);

    List<String> getTags();

    Recipe create(Recipe recipe);
}
