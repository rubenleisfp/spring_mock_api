package com.fp.mockapi.comments.model;

import com.fp.mockapi.carts.model.Cart;

import java.util.List;
import java.util.Objects;

/**
 * Clase envoltorio que contiene una lista de comments  dentro con su paginacion
 */
public class CommentPage {

	private List<Comment> comments;

	private int total;
	private int skip;
	private int limit;

	public CommentPage() {
	}
	public CommentPage(List<Comment> comments, int total, int skip, int limit) {
		this.comments = comments;
		this.total = total;
		this.skip = skip;
		this.limit = limit;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
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
		CommentPage that = (CommentPage) o;
		return total == that.total && skip == that.skip && limit == that.limit && Objects.equals(comments, that.comments);
	}

	@Override
	public int hashCode() {
		return Objects.hash(comments, total, skip, limit);
	}

	@Override
	public String toString() {
		return "CommentPage{" +
				"comments=" + comments +
				", total=" + total +
				", skip=" + skip +
				", limit=" + limit +
				'}';
	}
}
