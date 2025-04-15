package com.fp.mockapi.quotes.service;

import com.fp.mockapi.quotes.model.Quote;
import com.fp.mockapi.quotes.model.QuotePage;
import com.fp.mockapi.quotes.repository.QuoteRepository;
import com.fp.mockapi.recipes.model.Recipe;
import com.fp.mockapi.recipes.model.RecipePage;
import com.fp.mockapi.recipes.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class QuoteService {

	private static Logger LOG = LoggerFactory.getLogger(QuoteService.class);

	@Autowired
	private QuoteRepository quoteRepository;

	public QuoteService() {}

	public QuoteService(QuoteRepository quoteRepository) {
		this.quoteRepository = quoteRepository;
	}

	public QuotePage getAll() {
		return quoteRepository.getAll();
	}

	public Optional<Quote> getById(int id)	{
		return quoteRepository.getById(id);
	}
}