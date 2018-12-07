package com.monsanto.recipe.payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecipeResponseWrapper {
	@JsonProperty("status")
	private int status;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("count")
	private int count;
	
	@JsonProperty("recipes")
	List<RecipeResponse> recipes;
	
	public RecipeResponseWrapper() {
		
	}
	public RecipeResponseWrapper(List<RecipeResponse> recipes) {
		this.recipes=recipes;
	}
	public RecipeResponseWrapper(int status, String message,int count, List<RecipeResponse> recipes) {
		this.status=status;
		this.message=message;
		this.count=count;
		this.recipes=recipes;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<RecipeResponse> getRecipes() {
		return recipes;
	}
	public void setRecipes(List<RecipeResponse> recipes) {
		this.recipes = recipes;
	}

}
