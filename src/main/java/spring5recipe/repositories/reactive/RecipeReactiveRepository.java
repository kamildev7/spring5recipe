package spring5recipe.repositories.reactive;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import spring5recipe.domain.Recipe;

/**
 * @author kamildev7 on 2018-08-19.
 */
public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe, String> {
}
