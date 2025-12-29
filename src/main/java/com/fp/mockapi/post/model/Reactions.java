package com.fp.mockapi.post.model;

import java.util.Objects;

public class Reactions {
    private int likes;
    private int dislikes;

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reactions reaction = (Reactions) o;
        return likes == reaction.likes && dislikes == reaction.dislikes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(likes, dislikes);
    }

    @Override
    public String toString() {
        return "Reactions{" +
                "likes=" + likes +
                ", dislikes=" + dislikes +
                '}';
    }
}