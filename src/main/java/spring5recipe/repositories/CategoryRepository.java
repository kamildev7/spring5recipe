package spring5recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import spring5recipe.domain.Category;

import java.util.Optional;

/**
 * @author kamildev7 on 2018-08-12.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
}
