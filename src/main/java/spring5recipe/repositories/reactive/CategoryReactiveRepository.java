package spring5recipe.repositories.reactive;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import spring5recipe.domain.Category;

/**
 * @author kamildev7 on 2018-08-19.
 */
public interface CategoryReactiveRepository  extends ReactiveMongoRepository<Category, String> {
    Mono<Category> findByDescription(String description);
}
