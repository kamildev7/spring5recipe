package spring5recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import spring5recipe.domain.UnitOfMeasure;

import java.util.Optional;

/**
 * @author kamildev7 on 2018-08-12.
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByDescription(String desciption);
}
