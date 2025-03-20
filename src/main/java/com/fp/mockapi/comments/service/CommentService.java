package com.fp.mockapi.comments.service;

import com.fp.mockapi.comments.model.CommentPage;
import com.fp.mockapi.comments.repository.CommentRepository;
import com.fp.mockapi.products.model.Product;
import com.fp.mockapi.products.model.ProductPage;
import com.fp.mockapi.products.repository.ProductRepository;
import com.fp.mockapi.products.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CommentService {

	private static Logger LOG = LoggerFactory.getLogger(CommentService.class);

	@Autowired
	private CommentRepository commentRepository;

	public CommentPage getAll() {
		return commentRepository.getAll();
	}

}