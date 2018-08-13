package spring5recipe.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring5recipe.domain.Recipe;
import spring5recipe.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kamildev7 on 2018-08-12.
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the service");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
