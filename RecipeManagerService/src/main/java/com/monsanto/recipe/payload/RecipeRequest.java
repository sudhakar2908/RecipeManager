package com.monsanto.recipe.payload;

import javax.validation.constraints.NotBlank;

public class RecipeRequest {
	
	@NotBlank(message="Recipe name cannot be empty.")
	private String name;
	@NotBlank(message="ingredient1 cannot be missing.")
	private String ingredient1;
	private String ingredient2;
	private String ingredient3;
	private String ingredient4;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIngredient1() {
		return ingredient1;
	}
	public void setIngredient1(String ingredient1) {
		this.ingredient1 = ingredient1;
	}
	public String getIngredient2() {
		return ingredient2;
	}
	public void setIngredient2(String ingredient2) {
		this.ingredient2 = ingredient2;
	}
	public String getIngredient3() {
		return ingredient3;
	}
	public void setIngredient3(String ingredient3) {
		this.ingredient3 = ingredient3;
	}
	public String getIngredient4() {
		return ingredient4;
	}
	public void setIngredient4(String ingredient4) {
		this.ingredient4 = ingredient4;
	}

}
