package spring5recipe.services;

import reactor.core.publisher.Mono;
import spring5recipe.commands.IngredientCommand;

/**
 * @author kamildev7 on 2018-08-15.
 */
public interface IngredientService {
    Mono<IngredientCommand> findByRecipeIdAndIngredientId(String recipeId, String ingredientId);
    Mono<IngredientCommand> saveIngredientCommand(IngredientCommand command);

}
