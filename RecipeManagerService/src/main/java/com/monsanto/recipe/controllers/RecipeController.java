package com.monsanto.recipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monsanto.recipe.payload.ApiResponse;
import com.monsanto.recipe.payload.RecipeRequest;
import com.monsanto.recipe.service.RecipeService;

@RestController
@CrossOrigin(origins = "*")
public class RecipeController {
	@Autowired
	RecipeService recipeService;
	
	@GetMapping(value="/recipes", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getRecipe() {
		return recipeService.getRecipeList();
	}
	
	@GetMapping(value="/recipes/{recipeId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getRecipeById(@PathVariable("recipeId") Integer recipeId) {
		return recipeService.getRecipeById(recipeId);
	}
	
	@PostMapping(value="/recipes", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponse createRecipe(@RequestBody RecipeRequest recipeRequest) {
		return recipeService.createRecipe(recipeRequest);
	}

}
