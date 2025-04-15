package com.fp.mockapi.quotes.model;

import com.fp.mockapi.products.model.Product;

import java.util.List;
import java.util.Objects;

/**
 * Clase envoltorio que contiene una lista de productos dentro con su paginacion
 */
public class QuotePage {

	private List<Quote> quotes;

	private int total;
	private int skip;
	private int limit;


	public List<Quote> getProducts() {
		return quotes;
	}

	public void setProducts(List<Quote> products) {
		this.quotes = quotes;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		QuotePage quotePage = (QuotePage) o;
		return total == quotePage.total && skip == quotePage.skip && limit == quotePage.limit && Objects.equals(quotes, quotePage.quotes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(quotes, total, skip, limit);
	}

	@Override
	public String toString() {
		return "QuotePage{" +
				"quotes=" + quotes +
				", total=" + total +
				", skip=" + skip +
				", limit=" + limit +
				'}';
	}
}