package com.fp.mockapi.recipes.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.fp.mockapi.recipes.model.Recipe;
import com.fp.mockapi.recipes.model.RecipePage;
import com.fp.mockapi.recipes.repository.RecipeRepository;
import com.fp.mockapi.recipes.repository.impl.RecipeMemoryRepository;
import org.junit.Before;
import org.junit.Test;



public class RecipeServiceTest {

	private static final String BASE_PATH = "http://localhost:8080/api/recipes";

	private RecipeRepository recipeRepository;
	private RecipeService recipeService;

	@Before
	public void setUp() {

		recipeRepository = new RecipeMemoryRepository();
		recipeService = new RecipeService(recipeRepository);
	}
	@Test
	public void testGetAll()  {
		RecipePage recipePage = recipeService.getAll();
		assertNotNull(recipePage);
		assertNotNull(recipePage.getRecipes());

		assertEquals(30, recipePage.getRecipes().size());
		assertEquals(30, recipePage.getLimit());
		assertEquals(50, recipePage.getTotal());

		// Valida que el primer comentario sea el esperado
		assertEquals(getExpectedRecipe(), recipePage.getRecipes().get(0));
	}

	@Test
	public void testGetByTag() {
		RecipePage recipePage = recipeService.getByTag("Italian");
		assertNotNull(recipePage.getRecipes());
		// Valida que devuelva 6 elementos
		assertEquals(6, recipePage.getRecipes().size());
		// Valida que el primer elemento sea el esperado
		assertEquals(getExpectedRecipe(), recipePage.getRecipes().get(0));
	}

	@Test
	public void testGetById()  {
		Optional<Recipe> recipe = recipeService.getById(1);
		assertNotNull(recipe.get());
		assertEquals(getExpectedRecipe(), recipe.get());
	}

	@Test
	public void testCreate() {
		Recipe recipeResponse =recipeService.createRecipe(getExpectedRecipe());
		assertNotNull(recipeResponse);
		Recipe expectedRecipe = getExpectedRecipe();
		expectedRecipe.setId(51);
		assertEquals(expectedRecipe, recipeResponse);
	}

	@Test
	public void testGetTags() {
		List<String> tags = recipeService.getTags();
		assertNotNull(tags);
		assertEquals(87, tags.size());
	}

	private Recipe getExpectedRecipe() {
		Recipe expectedRecipe = new Recipe();
		expectedRecipe.setId(1);
		expectedRecipe.setName("Classic Margherita Pizza");
		expectedRecipe.setIngredients(Arrays.asList(
				"Pizza dough",
				"Tomato sauce",
				"Fresh mozzarella cheese",
				"Fresh basil leaves",
				"Olive oil",
				"Salt and pepper to taste"
		));
		expectedRecipe.setInstructions(Arrays.asList(
				"Preheat the oven to 475°F (245°C).",
				"Roll out the pizza dough and spread tomato sauce evenly.",
				"Top with slices of fresh mozzarella and fresh basil leaves.",
				"Drizzle with olive oil and season with salt and pepper.",
				"Bake in the preheated oven for 12-15 minutes or until the crust is golden brown.",
				"Slice and serve hot."
		));
		expectedRecipe.setPrepTimeMinutes(20);
		expectedRecipe.setCookTimeMinutes(15);
		expectedRecipe.setServings(4);
		expectedRecipe.setDifficulty("Easy");
		expectedRecipe.setCuisine("Italian");
		expectedRecipe.setCaloriesPerServing(300);
		expectedRecipe.setTags(Arrays.asList("Pizza", "Italian"));
		expectedRecipe.setUserId(166);
		expectedRecipe.setImage("https://cdn.dummyjson.com/recipe-images/1.webp");
		expectedRecipe.setRating(4.6);
		expectedRecipe.setReviewCount(98);
		expectedRecipe.setMealType(Arrays.asList("Dinner"));
		return expectedRecipe;
	}

}
