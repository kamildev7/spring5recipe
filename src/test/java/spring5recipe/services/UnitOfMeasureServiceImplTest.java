package spring5recipe.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import spring5recipe.commands.UnitOfMeasureCommand;
import spring5recipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import spring5recipe.domain.UnitOfMeasure;
import spring5recipe.repositories.reactive.UnitOfMeasureReactiveRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author kamildev7 on 2018-08-16.
 */
public class UnitOfMeasureServiceImplTest {

    @Mock
    UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;

    UnitOfMeasureToUnitOfMeasureCommand command = new UnitOfMeasureToUnitOfMeasureCommand();

    UnitOfMeasureService unitOfMeasureService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        unitOfMeasureService = new UnitOfMeasureServiceImpl(unitOfMeasureReactiveRepository, command);
    }

    @Test
    public void listAllUoms() {
        //given
        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId("1");
        unitOfMeasures.add(unitOfMeasure);

        UnitOfMeasure unitOfMeasure2 = new UnitOfMeasure();
        unitOfMeasure2.setId("2");
        unitOfMeasures.add(unitOfMeasure2);

        //when
        when(unitOfMeasureReactiveRepository.findAll()).thenReturn(Flux.just(unitOfMeasure, unitOfMeasure2));

        List<UnitOfMeasureCommand> commands = unitOfMeasureService.listAllUoms().collectList().block();

        //then
        assertEquals(2, commands.size());
        verify(unitOfMeasureReactiveRepository, times(1)).findAll();


    }
}