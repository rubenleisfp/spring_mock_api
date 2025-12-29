package com.fp.mockapi.post.service;

import com.fp.mockapi.comments.model.CommentPage;
import com.fp.mockapi.comments.repository.CommentRepository;
import com.fp.mockapi.post.model.Post;
import com.fp.mockapi.post.model.PostPage;
import com.fp.mockapi.post.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PostService {

	private static Logger LOG = LoggerFactory.getLogger(PostService.class);

	@Autowired
	private PostRepository postRepository;

	public PostPage getAll() {
		return postRepository.getAll();
	}

	public PostPage getAll(int limit, int skip) {
		return postRepository.getAll(limit, skip);
	}

	public Optional<Post> delete(int id) {
		return postRepository.delete(id);
	}

}