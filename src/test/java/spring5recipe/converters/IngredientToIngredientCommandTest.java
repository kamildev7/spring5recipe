package spring5recipe.converters;

import org.junit.Before;
import org.junit.Test;
import spring5recipe.commands.IngredientCommand;
import spring5recipe.domain.Ingredient;
import spring5recipe.domain.Recipe;
import spring5recipe.domain.UnitOfMeasure;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author kamildev7 on 2018-08-16.
 */
public class IngredientToIngredientCommandTest {

    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final Long ID_VALUE = new Long(1L);
    public static final Long UOM_ID = new Long(2L);

    IngredientToIngredientCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void testNullParamaeter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    public void convert() throws Exception {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);
//        command.setRecipeId(RECIPE.getId());
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(UOM_ID);
        ingredient.setUnitOfMeasure(unitOfMeasure);

        //when
        IngredientCommand command = converter.convert(ingredient);

        //then
        assertNotNull(command);
        assertNotNull(command.getUnitOfMeasure());
        assertEquals(ID_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
        assertEquals(AMOUNT, command.getAmount());
        assertEquals(UOM_ID, command.getUnitOfMeasure().getId());
    }

    @Test
    public void convertWithNullUOM() throws Exception {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);

        //when
        IngredientCommand command = converter.convert(ingredient);

        //then
        assertNotNull(command);
        assertNull(command.getUnitOfMeasure());
        assertEquals(ID_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
        assertEquals(AMOUNT, command.getAmount());
    }
}