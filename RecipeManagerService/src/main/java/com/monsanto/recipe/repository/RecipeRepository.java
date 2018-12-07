package com.monsanto.recipe.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.monsanto.recipe.models.Recipe;


@Transactional
@Repository
public interface RecipeRepository extends PagingAndSortingRepository<Recipe, Integer> {
	@Query("select r from Recipe r")
	List<Recipe> getAllRecipes();
	Recipe findById(@Param("id") int id);
	Recipe findByName(@Param("recipeName") String recipeName);
}
