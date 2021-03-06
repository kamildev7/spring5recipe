package spring5recipe.services;

import spring5recipe.commands.RecipeCommand;
import spring5recipe.domain.Recipe;

import java.util.Set;

/**
 * @author kamildev7 on 2018-08-12.
 */
public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);

    RecipeCommand findCommandById(Long id);

    void deleteById(Long id);
}
