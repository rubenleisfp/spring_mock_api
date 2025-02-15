package com.fp.mockapi.recipes.model;

import java.util.List;
import java.util.Objects;

public class RecipePage {
    private List<Recipe> recipes;
    private int total;
    private int skip;
    private int limit;

    // Getters y setters


    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
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
        RecipePage that = (RecipePage) o;
        return total == that.total && skip == that.skip && limit == that.limit && Objects.equals(recipes, that.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipes, total, skip, limit);
    }

    @Override
    public String toString() {
        return "RecipePage{" +
                "recipes=" + recipes +
                ", total=" + total +
                ", skip=" + skip +
                ", limit=" + limit +
                '}';
    }
}