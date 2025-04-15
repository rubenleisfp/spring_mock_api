package com.fp.mockapi.quotes.model;

import java.util.Objects;

public class Quote {

    public Quote(int id, String quote, String author) {
        this.id = id;
        this.quote = quote;
        this.author = author;
    }

    private int id;
    private String quote;
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote1 = (Quote) o;
        return id == quote1.id && Objects.equals(quote, quote1.quote) && Objects.equals(author, quote1.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quote, author);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
