package com.fp.mockapi.post.controller;

import com.fp.mockapi.post.model.Post;
import com.fp.mockapi.post.model.PostPage;
import com.fp.mockapi.post.service.PostService;
import com.fp.mockapi.quotes.model.Quote;
import com.fp.mockapi.quotes.model.QuotePage;
import com.fp.mockapi.quotes.service.QuoteService;
import com.fp.mockapi.utils.exceptions.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 *
 */

@RestController
@RequestMapping("/api/posts")
public class PostRestController {

	@Autowired
	private PostService postService;


	@Operation(summary = "Get all post")
	@GetMapping("/all")
	public PostPage findAll() {
		return postService.getAll();
	}

	@Operation(summary = "Get all post")
	@GetMapping()
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Post found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = PostPage.class))}),
			@ApiResponse(responseCode = "404", description = "Post not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})})
	public ResponseEntity<PostPage> findAll(@RequestParam(value = "limit", required = false) Integer limit,
													 @RequestParam(value = "skip", required = false) Integer skip) {
		if (limit!= null && skip != null) {
			return ResponseEntity.ok(postService.getAll(limit, skip));
		} else {
			return ResponseEntity.ok(postService.getAll());
		}
	}


	//https://dummyjson.com/posts/1 DELETED
	@Operation(summary = "Delete a post by its id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Post deleted", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = PostPage.class))}),
			@ApiResponse(responseCode = "404", description = "Post not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})})
	@DeleteMapping(value = "/{postId}")
	public ResponseEntity<?> deleteById(@PathVariable("postId") Integer postId) {
		Optional<Post> delete = postService.delete(postId);
		if (delete.isPresent()) {
			return ResponseEntity.ok().body(delete);
		} else {
			return responseNotFound(postId);
		}
	}



//	@Operation(summary = "Get a post by its id")
//	@ApiResponses(value = {
//			@ApiResponse(responseCode = "200", description = "Post found", content = {
//					@Content(mediaType = "application/json", schema = @Schema(implementation = PostPage.class))}),
//			@ApiResponse(responseCode = "404", description = "Post not found", content = {
//					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})})
//
////	@GetMapping(value = "/{quoteId}")
////	public ResponseEntity<?> getById(@PathVariable("postId") Integer quoteId) {
////
////		Optional<Quote> quote = postService.getById(quoteId);
////		if (quote.isPresent()) {
////			return ResponseEntity.ok().body(quote);
////		} else {
////			return responseNotFound(quoteId);
////		}
//	}

	private ResponseEntity<?> responseNotFound(Integer quoteId) {
		String errorMessage = "Post with id '" + quoteId + "' not found";
		return responseNotFound(errorMessage);
	}

	private ResponseEntity<?> responseNotFound(String message) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(message));
	}

}