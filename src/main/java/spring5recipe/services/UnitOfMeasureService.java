package spring5recipe.services;

import reactor.core.publisher.Flux;
import spring5recipe.commands.UnitOfMeasureCommand;

/**
 * @author kamildev7 on 2018-08-15.
 */
public interface UnitOfMeasureService {
    Flux<UnitOfMeasureCommand> listAllUoms();
}
