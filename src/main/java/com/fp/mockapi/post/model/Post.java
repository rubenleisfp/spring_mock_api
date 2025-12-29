package com.fp.mockapi.post.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
	private int id;
	private String title;
	private String body;
	private List<String> tags;
	private Reactions reactions;
	private int views;
	private int userId;
	private boolean isDeleted;
	private String deletedOn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Reactions getReactions() {
		return reactions;
	}

	public void setReactions(Reactions reactions) {
		this.reactions = reactions;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean deleted) {
		isDeleted = deleted;
	}

	public String getDeletedOn() {
		return deletedOn;
	}

	public void setDeletedOn(String deletedOn) {
		this.deletedOn = deletedOn;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Post post = (Post) o;
		return id == post.id && views == post.views && userId == post.userId && isDeleted == post.isDeleted && Objects.equals(title, post.title) && Objects.equals(body, post.body) && Objects.equals(tags, post.tags) && Objects.equals(reactions, post.reactions);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, body, tags, reactions, views, userId, isDeleted, deletedOn);
	}

	@Override
	public String toString() {
		return "Post{" +
				"id=" + id +
				", title='" + title + '\'' +
				", body='" + body + '\'' +
				", tags=" + tags +
				", reactions=" + reactions +
				", views=" + views +
				", userId=" + userId +
				", isDeleted=" + isDeleted +
				", deletedOn='" + deletedOn + '\'' +
				'}';
	}
}