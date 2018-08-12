package spring5recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import spring5recipe.domain.UnitOfMeasure;

/**
 * @author kamildev7 on 2018-08-12.
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
