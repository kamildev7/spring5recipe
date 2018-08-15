package spring5recipe.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring5recipe.commands.IngredientCommand;
import spring5recipe.converters.IngredientToIngredientCommand;
import spring5recipe.domain.Recipe;
import spring5recipe.repositories.RecipeRepository;

import java.util.Optional;

/**
 * @author kamildev7 on 2018-08-15.
 */
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (!recipeOptional.isPresent()) {
            //todo implement error handling
            log.error("recipe id not found. Id: " + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        if(!ingredientCommandOptional.isPresent())
            //todo impl error handling
            log.error("Ingredient id not found: " + ingredientId);

        return ingredientCommandOptional.get();
    }
}
