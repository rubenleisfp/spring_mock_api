package com.fp.mockapi.products.controller;

import java.util.Optional;

import com.fp.mockapi.products.model.Product;
import com.fp.mockapi.products.model.ProductPage;
import com.fp.mockapi.products.service.ProductService;
import com.fp.mockapi.utils.exceptions.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 *
 */

//@RestController
//@RequestMapping("/api/products")
public class ProductRestController {

	@Autowired
	private ProductService productService;


	@Operation(summary = "Get all products")
	@GetMapping()
	public ProductPage findAll() {
		return productService.getAll();
	}


	@Operation(summary = "Get a product by its id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))}),
			@ApiResponse(responseCode = "404", description = "Product not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})})

	@GetMapping(value = "/{productId}")
	public ResponseEntity<?> getById(@PathVariable("productId") Integer productId) {

		Optional<Product> product = productService.getById(productId);
		if (product.isPresent()) {
			return ResponseEntity.ok().body(product);
		} else {
			return responseNotFound(productId);
		}
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

	private ResponseEntity<?> responseNotFound(Integer productId) {
		String errorMessage = "Product with id '" + productId + "' not found";
		return responseNotFound(errorMessage);
	}

	private ResponseEntity<?> responseNotFound(String message) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(message));
	}

}