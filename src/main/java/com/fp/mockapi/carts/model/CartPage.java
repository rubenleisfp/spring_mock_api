package com.fp.mockapi.carts.model;

import java.util.List;
import java.util.Objects;

/**
 * Clase envoltorio que contiene una lista de carts dentro con su paginacion
 */
public class CartPage {

	private List<Cart> carts;

	private int total;
	private int skip;
	private int limit;


	public List<Cart> getCarts() {
		return carts;
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

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CartPage cartPage = (CartPage) o;
		return total == cartPage.total && skip == cartPage.skip && limit == cartPage.limit && Objects.equals(carts, cartPage.carts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(carts, total, skip, limit);
	}

	@Override
	public String toString() {
		return "CartPage{" +
				"carts=" + carts +
				", total=" + total +
				", skip=" + skip +
				", limit=" + limit +
				'}';
	}
}
