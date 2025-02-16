package com.fp.mockapi.recipes.model;

import java.util.List;
import java.util.Objects;

public class Recipe {
    private int id;
    private String name;
    private List<String> ingredients;
    private List<String> instructions;
    private int prepTimeMinutes;
    private int cookTimeMinutes;
    private int servings;
    private String difficulty;
    private String cuisine;
    private int caloriesPerServing;
    private List<String> tags;
    private int userId;
    private String image;
    private double rating;
    private int reviewCount;
    private List<String> mealType;

    // Getters y setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public int getPrepTimeMinutes() {
        return prepTimeMinutes;
    }

    public void setPrepTimeMinutes(int prepTimeMinutes) {
        this.prepTimeMinutes = prepTimeMinutes;
    }

    public int getCookTimeMinutes() {
        return cookTimeMinutes;
    }

    public void setCookTimeMinutes(int cookTimeMinutes) {
        this.cookTimeMinutes = cookTimeMinutes;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getCaloriesPerServing() {
        return caloriesPerServing;
    }

    public void setCaloriesPerServing(int caloriesPerServing) {
        this.caloriesPerServing = caloriesPerServing;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public List<String> getMealType() {
        return mealType;
    }

    public void setMealType(List<String> mealType) {
        this.mealType = mealType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id && prepTimeMinutes == recipe.prepTimeMinutes && cookTimeMinutes == recipe.cookTimeMinutes && servings == recipe.servings && caloriesPerServing == recipe.caloriesPerServing && userId == recipe.userId && Double.compare(rating, recipe.rating) == 0 && reviewCount == recipe.reviewCount && Objects.equals(name, recipe.name) && Objects.equals(ingredients, recipe.ingredients) && Objects.equals(instructions, recipe.instructions) && Objects.equals(difficulty, recipe.difficulty) && Objects.equals(cuisine, recipe.cuisine) && Objects.equals(tags, recipe.tags) && Objects.equals(image, recipe.image) && Objects.equals(mealType, recipe.mealType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ingredients, instructions, prepTimeMinutes, cookTimeMinutes, servings, difficulty, cuisine, caloriesPerServing, tags, userId, image, rating, reviewCount, mealType);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", instructions=" + instructions +
                ", prepTimeMinutes=" + prepTimeMinutes +
                ", cookTimeMinutes=" + cookTimeMinutes +
                ", servings=" + servings +
                ", difficulty='" + difficulty + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", caloriesPerServing=" + caloriesPerServing +
                ", tags=" + tags +
                ", userId=" + userId +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                ", reviewCount=" + reviewCount +
                ", mealType=" + mealType +
                '}';
    }
}