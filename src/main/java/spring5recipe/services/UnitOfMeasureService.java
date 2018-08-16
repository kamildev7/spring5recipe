package spring5recipe.services;

import spring5recipe.commands.UnitOfMeasureCommand;

import java.util.Set;

/**
 * @author kamildev7 on 2018-08-15.
 */
public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}
