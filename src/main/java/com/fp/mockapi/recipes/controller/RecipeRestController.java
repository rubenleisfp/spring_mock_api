package com.fp.mockapi.recipes.controller;

import com.fp.mockapi.carts.dto.CartRequest;
import com.fp.mockapi.carts.model.Cart;
import com.fp.mockapi.carts.model.CartPage;
import com.fp.mockapi.carts.service.CartService;
import com.fp.mockapi.recipes.model.Recipe;
import com.fp.mockapi.recipes.model.RecipePage;
import com.fp.mockapi.recipes.service.RecipeService;
import com.fp.mockapi.utils.exceptions.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 */

@RestController
@RequestMapping("/api/recipes")
public class RecipeRestController {

	@Autowired
	private RecipeService recipeService;


	@Operation(summary = "Get all recipes")
	@GetMapping()
	public RecipePage findAll() {
		return recipeService.getAll();
	}


	@Operation(summary = "Get a recipe by its id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Recipe found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Recipe.class))}),
			@ApiResponse(responseCode = "404", description = "Recipe not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})})

	@GetMapping(value = "/{recipeId}")
	public ResponseEntity<?> getById(@PathVariable("recipeId") Integer recipeId) {

		Optional<Recipe> cart = recipeService.getById(recipeId);
		if (cart.isPresent()) {
			return ResponseEntity.ok().body(cart);
		} else {
			return responseNotFound(recipeId);
		}
	}


	@Operation(summary = "Get a recipe page by tag")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Recipe found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = RecipePage.class))})})
	@GetMapping(value = "/tag/{tag}")
	public RecipePage getByTag(@PathVariable("tag") String tag)	{
		return recipeService.getByTag(tag);
	}

	@Operation(summary = "Get recipes tag")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Tags found", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = String.class)))})})
	@GetMapping(value = "/tags")
	public List<String> getTags()	{
		return recipeService.getTags();
	}

	@Operation(summary = "Create a recipe")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Recipe created", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cart.class))}),
			@ApiResponse(responseCode = "400", description = "Data not valid", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})})
	@PostMapping("/add")
	public ResponseEntity<Recipe> create(@Valid @RequestBody Recipe recipe) {
		Recipe recipeResponse = recipeService.createRecipe(recipe);
		return new ResponseEntity<>(recipeResponse, HttpStatus.CREATED);
	}
/*

	@Operation(summary = "Create a book")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Book created", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = LibroDto.class))}),
			@ApiResponse(responseCode = "400", description = "Data not valid", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})})
	@PostMapping("/libros/add")
	public ResponseEntity<LibroDto> createBook(@Valid @RequestBody LibroDto libroDto) {
		LibroDto dtoWithId = bibliotecaService.createLibro(libroDto);
		return new ResponseEntity<>(dtoWithId, HttpStatus.CREATED);

	}

	@Operation(summary = "Create a copy attached to book")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Copy created", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = EjemplarDto.class))}),
			@ApiResponse(responseCode = "400", description = "Data not valid", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
			@ApiResponse(responseCode = "404", description = "Book not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})})
	@PostMapping("/libros/{libroId}/ejemplares/add")
	public ResponseEntity<?> createCopy(@PathVariable("libroId") Long libroId, @Valid @RequestBody EjemplarDto ejemplarDto) {
		EjemplarDto ejemplarDtoCreated;
		try {
			ejemplarDtoCreated = bibliotecaService.createEjemplar(libroId, ejemplarDto);
			return new ResponseEntity<>(ejemplarDtoCreated, HttpStatus.CREATED);
		} catch (NotFoundException e) {
			return responseNotFound(e.getMessage());
		}
	}
	*/

	private ResponseEntity<?> responseNotFound(Integer cartId) {
		String errorMessage = "Recipe with id '" + cartId + "' not found";
		return responseNotFound(errorMessage);
	}

	private ResponseEntity<?> responseNotFound(String message) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(message));
	}

}