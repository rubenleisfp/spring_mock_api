package com.fp.mockapi.recipes.service;

import com.fp.mockapi.recipes.model.Recipe;
import com.fp.mockapi.recipes.model.RecipePage;
import com.fp.mockapi.recipes.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class RecipeService {

	private static Logger LOG = LoggerFactory.getLogger(RecipeService.class);

	@Autowired
	private RecipeRepository recipeRepository;

	public RecipePage getAll() {
		RecipePage productPage = new RecipePage();
		return recipeRepository.getAll();
	}

	public Optional<Recipe> getById(int id)	{
		return recipeRepository.getById(id);
	}

	public RecipePage getRecipeByTag(String tag)	{
		return recipeRepository.getRecipeByTag(tag);
	}
}