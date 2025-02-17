package com.fp.mockapi.recipes.service;

import com.fp.mockapi.recipes.model.Recipe;
import com.fp.mockapi.recipes.model.RecipePage;
import com.fp.mockapi.recipes.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RecipeService {

	private static Logger LOG = LoggerFactory.getLogger(RecipeService.class);

	@Autowired
	private RecipeRepository recipeRepository;

	public RecipeService() {

	}

	public RecipeService(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	public RecipePage getAll() {
		return recipeRepository.getAll();
	}

	public Optional<Recipe> getById(int id)	{
		return recipeRepository.getById(id);
	}

	public RecipePage getByTag(String tag)	{
		return recipeRepository.getByTag(tag);
	}

	public List<String> getTags() {
		return recipeRepository.getTags();
	}

	public Recipe createRecipe(Recipe recipe) {
		return  recipeRepository.create(recipe);
	}
}