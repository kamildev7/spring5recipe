package spring5recipe.repositories.reactive;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import spring5recipe.domain.UnitOfMeasure;

/**
 * @author kamildev7 on 2018-08-19.
 */
public interface UnitOfMeasureReactiveRepository extends ReactiveMongoRepository<UnitOfMeasure, String> {
}
