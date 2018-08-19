package spring5recipe.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import spring5recipe.commands.UnitOfMeasureCommand;
import spring5recipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import spring5recipe.repositories.reactive.UnitOfMeasureReactiveRepository;

/**
 * @author kamildev7 on 2018-08-15.
 */
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureCommand) {
        this.unitOfMeasureReactiveRepository = unitOfMeasureReactiveRepository;
        this.unitOfMeasureCommand = unitOfMeasureCommand;
    }


    @Override
    public Flux<UnitOfMeasureCommand> listAllUoms() {
        return unitOfMeasureReactiveRepository
                .findAll()
                .map(unitOfMeasureCommand::convert);
    }
}
