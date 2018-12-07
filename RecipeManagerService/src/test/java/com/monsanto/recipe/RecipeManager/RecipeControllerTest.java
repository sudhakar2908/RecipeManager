package com.monsanto.recipe.RecipeManager;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.monsanto.recipe.controllers.RecipeController;
import com.monsanto.recipe.service.RecipeService;

@RunWith(SpringRunner.class)
@WebMvcTest(RecipeController.class)
public class RecipeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RecipeService recipeServiceMock;
			
	
	@Test
	public void getRecipeByIdTest() throws Exception {	

		mockMvc.perform(get("/recipes/1")
	               .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
	               .andExpect(status().isOk());	               
	}
	
	@Test
	public void getRecipesListTest() throws Exception {	

		mockMvc.perform(get("/recipes")
	               .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
	               .andExpect(status().isOk());	               
	}

	

}
