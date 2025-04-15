package com.fp.mockapi.quotes.repository;

import com.fp.mockapi.quotes.model.Quote;
import com.fp.mockapi.quotes.model.QuotePage;

import java.util.Optional;

public interface QuoteRepository {
    QuotePage getAll();

    Optional<Quote> getById(int id);
}
