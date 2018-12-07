package com.monsanto.recipe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.monsanto.recipe.models.Recipe;
import com.monsanto.recipe.payload.ApiResponse;
import com.monsanto.recipe.payload.RecipeRequest;
import com.monsanto.recipe.payload.RecipeResponse;
import com.monsanto.recipe.payload.RecipeResponseWrapper;
import com.monsanto.recipe.repository.RecipeRepository;
import com.monsanto.recipe.util.Converter;

@Service("recipeService")
public class RecipeService {
	@Autowired
	RecipeRepository recipeRepository;
	public ResponseEntity<?> getRecipeList() {
		try {
			RecipeResponseWrapper recipes = getRecipeResponseWrapperPayload(recipeRepository.getAllRecipes());
		    Converter<RecipeResponseWrapper> converter = new Converter<>();
			String response = converter.getJson(recipes);
			return new ResponseEntity<>(response, HttpStatus.OK);
			} 
			catch(Exception e) {
				System.out.println("Error :: " + e);
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
	public RecipeResponseWrapper getRecipeResponseWrapperPayload(List<Recipe> list) {
		List<RecipeResponse> recipes = new ArrayList<>();
		if(null != list && !list.isEmpty()) {
			recipes = list.stream().map(recipe -> {
				return new RecipeResponse(recipe.getId(), recipe.getName());
			}).collect(Collectors.toList());
			
		}
		if(recipes.isEmpty()) {
			return new RecipeResponseWrapper(HttpStatus.OK.value(),"success",0,null);
		}
		return new RecipeResponseWrapper(HttpStatus.OK.value(),"success",recipes.size(),recipes);
	}
	
	public ResponseEntity<?> getRecipeById(int recipeId) {
		try {
			Recipe recipe = recipeRepository.findById(recipeId);
			if (recipe == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else {
				
				RecipeResponse recipeResp = getRecipeResponsePayload(recipe);
				Converter<RecipeResponse> converter = new Converter<>();
				String response = converter.getJson(recipeResp);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public RecipeResponse getRecipeResponsePayload(Recipe recipe) {
		if(null == recipe) return null;
		RecipeResponse recipeResponse = new RecipeResponse();
		recipeResponse.setId(recipe.getId());
		recipeResponse.setName(recipe.getName());
		recipeResponse.setIngredient1(recipe.getIngredient1());
		recipeResponse.setIngredient2(recipe.getIngredient2());
		recipeResponse.setIngredient3(recipe.getIngredient3());
		recipeResponse.setIngredient4(recipe.getIngredient4());
		
		return recipeResponse;
	}
	
	public ApiResponse createRecipe(RecipeRequest recipeRequest) {
		try {
			String recipeName = recipeRequest.getName();
			if (recipeName == null || recipeName.trim().isEmpty()) {
				return new ApiResponse(false, "Recipe name cannot be empty", HttpStatus.BAD_REQUEST.value());
			}
			String ingredient1 = recipeRequest.getIngredient1();
			String ingredient2 = recipeRequest.getIngredient2();
			String ingredient3 = recipeRequest.getIngredient3();
			String ingredient4 = recipeRequest.getIngredient4();
			
			if(!(
					isValidIngredient(ingredient1) ||
					isValidIngredient(ingredient2) ||
					isValidIngredient(ingredient3) ||
					isValidIngredient(ingredient4)
					
				)) {
				return new ApiResponse(false, "Atleast one ingredient need to be provide", HttpStatus.BAD_REQUEST.value());
			}
			
			Recipe recipe = recipeRepository.findByName(recipeName.trim());
			if (recipe != null) {
				return new ApiResponse(false, "Recipe information already exist", HttpStatus.BAD_REQUEST.value());
			}
			else {
				recipe = new Recipe();
				recipe.setName(recipeName.trim());
				recipe.setIngredient1(ingredient1);
				recipe.setIngredient2(ingredient2);
				recipe.setIngredient3(ingredient3);
				recipe.setIngredient4(ingredient4);
				recipeRepository.save(recipe);
				return new ApiResponse(true, "Recipe information added succesfully", HttpStatus.CREATED.value());
			}
		}catch(Exception e) {
			return new ApiResponse(false, "Unable to add Recipe information", HttpStatus.CREATED.value());
		}
	}
	
	boolean isValidIngredient(String ingredient) {
		return (ingredient!=null && !ingredient.trim().isEmpty());
	}

}
