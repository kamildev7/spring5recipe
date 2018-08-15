package spring5recipe.services;

import spring5recipe.commands.IngredientCommand;

/**
 * @author kamildev7 on 2018-08-15.
 */
public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
