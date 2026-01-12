package com.fp.mockapi.quotes.controller;

import com.fp.mockapi.quotes.model.Quote;
import com.fp.mockapi.quotes.model.QuotePage;
import com.fp.mockapi.quotes.service.QuoteService;
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

//@RestController
//@RequestMapping("/api/quotes")
public class QuoteRestController {

	@Autowired
	private QuoteService quoteService;


	@Operation(summary = "Get all quotes")
	@GetMapping()
	public QuotePage findAll() {
		return quoteService.getAll();
	}


	@Operation(summary = "Get a quote by its id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Quote found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Quote.class))}),
			@ApiResponse(responseCode = "404", description = "Quote not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})})

	@GetMapping(value = "/{quoteId}")
	public ResponseEntity<?> getById(@PathVariable("quoteId") Integer quoteId) {

		Optional<Quote> quote = quoteService.getById(quoteId);
		if (quote.isPresent()) {
			return ResponseEntity.ok().body(quote);
		} else {
			return responseNotFound(quoteId);
		}
	}

	private ResponseEntity<?> responseNotFound(Integer quoteId) {
		String errorMessage = "Quote with id '" + quoteId + "' not found";
		return responseNotFound(errorMessage);
	}

	private ResponseEntity<?> responseNotFound(String message) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(message));
	}

}