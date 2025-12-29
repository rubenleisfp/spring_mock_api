package com.fp.mockapi.post.model;
import java.util.List;
import java.util.Objects;

public class PostPage {
    private List<Post> posts;
    private int total;
    private int skip;
    private int limit;

    public PostPage() {}

    // Constructor
    public PostPage(List<Post> posts, int total, int skip, int limit) {
        this.posts = posts;
        this.total = total;
        this.skip = skip;
        this.limit = limit;
    }

    // Getters y Setters
    public List<Post> getPosts() {
        return posts;
    }

    public int getTotal() {
        return total;
    }

    public int getSkip() {
        return skip;
    }

    public int getLimit() {
        return limit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostPage postPage = (PostPage) o;
        return total == postPage.total && skip == postPage.skip && limit == postPage.limit && Objects.equals(posts, postPage.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posts, total, skip, limit);
    }

    @Override
    public String toString() {
        return "PostPage{" +
                "posts=" + posts +
                ", total=" + total +
                ", skip=" + skip +
                ", limit=" + limit +
                '}';
    }
}