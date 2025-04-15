package com.fp.mockapi.quotes.repository.impl;

import com.fp.mockapi.quotes.model.Quote;
import com.fp.mockapi.quotes.model.QuotePage;
import com.fp.mockapi.quotes.repository.QuoteRepository;
import com.fp.mockapi.utils.exceptions.JsonUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class QuoteMemoryRepository implements QuoteRepository {

    private final QuotePage quotePage;

    public QuoteMemoryRepository() {
        JsonUtils jsonUtils = new JsonUtils();
        quotePage = jsonUtils.getQuotesPage();
    }

    @Override
    public QuotePage getAll() {
        return quotePage;
    }

    @Override
    public Optional<Quote> getById(int id) {
        return quotePage.getProducts().stream()
                .filter(quote -> quote.getId() ==id)
                .findFirst();
    }
}
