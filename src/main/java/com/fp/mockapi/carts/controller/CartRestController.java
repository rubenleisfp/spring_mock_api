package com.fp.mockapi.carts.controller;

import java.util.Optional;

import com.fp.mockapi.carts.dto.CartRequest;
import com.fp.mockapi.carts.model.Cart;
import com.fp.mockapi.carts.model.CartPage;
import com.fp.mockapi.carts.service.CartService;
import com.fp.mockapi.utils.exceptions.ErrorResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 *
 */

@RestController
@RequestMapping("/api/carts")
public class CartRestController {

	@Autowired
	private CartService cartService;


	@Operation(summary = "Get all carts")
	@GetMapping()
	public CartPage findAll() {
		return cartService.getAll();
	}

/*
	@Operation(summary = "Get a cart by its id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cart found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cart.class))}),
			@ApiResponse(responseCode = "404", description = "Cart not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})})

	@GetMapping(value = "/{cartId}")
	public ResponseEntity<?> getById(@PathVariable("cartId") Integer cartId) {

		Optional<Cart> cart = cartService.getById(cartId);
		if (cart.isPresent()) {
			return ResponseEntity.ok().body(cart);
		} else {
			return responseNotFound(cartId);
		}
	}
	*/


	@Operation(summary = "Get a cart page by user id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cart found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = CartPage.class))})})
	@GetMapping(value = "/user/{userId}")
	public CartPage getByUserId(@PathVariable("userId") Integer userId)	{
		return cartService.getByUserId(userId);
	}

	@Operation(summary = "Create a cart")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Cart created", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cart.class))}),
			@ApiResponse(responseCode = "400", description = "Data not valid", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})})
	@PostMapping("/add")
	public ResponseEntity<Cart> createCart(@Valid @RequestBody CartRequest cartRequest) {
		Cart cart = cartService.getAddHarcodedResponse();
		return new ResponseEntity<>(cart, HttpStatus.CREATED);
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
		String errorMessage = "Cart with id '" + cartId + "' not found";
		return responseNotFound(errorMessage);
	}

	private ResponseEntity<?> responseNotFound(String message) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(message));
	}

}