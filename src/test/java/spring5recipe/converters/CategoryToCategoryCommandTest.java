package spring5recipe.converters;

import org.junit.Before;
import org.junit.Test;
import spring5recipe.commands.CategoryCommand;
import spring5recipe.domain.Category;

import static org.junit.Assert.*;

/**
 * @author kamildev7 on 2018-08-16.
 */
public class CategoryToCategoryCommandTest {

    public static final String DESCRIPTION = "description";
    public static final String ID_VALUE = new String("1");

    CategoryToCategoryCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void convert() throws Exception {
        //given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand command = converter.convert(category);

        //then
        assertNotNull(command);
        assertEquals(ID_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
    }
}