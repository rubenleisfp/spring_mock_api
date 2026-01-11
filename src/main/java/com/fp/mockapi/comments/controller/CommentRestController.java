package com.fp.mockapi.comments.controller;

import com.fp.mockapi.comments.model.CommentPage;
import com.fp.mockapi.comments.service.CommentService;
import com.fp.mockapi.products.model.ProductPage;
import com.fp.mockapi.utils.exceptions.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

/**
 *
 */

//@RestController
//@RequestMapping("/api/comments")
public class CommentRestController {

	@Autowired
	private CommentService commentService;

	@Operation(summary = "Get all comments")
	@GetMapping()
	public CommentPage findAll() {
		return commentService.getAll();
	}

	private ResponseEntity<?> responseNotFound(Integer productId) {
		String errorMessage = "Comment with id '" + productId + "' not found";
		return responseNotFound(errorMessage);
	}

	private ResponseEntity<?> responseNotFound(String message) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(message));
	}

}