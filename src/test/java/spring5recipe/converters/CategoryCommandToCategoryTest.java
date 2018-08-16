package spring5recipe.converters;

import org.junit.Before;
import org.junit.Test;
import spring5recipe.commands.CategoryCommand;
import spring5recipe.domain.Category;

import static org.junit.Assert.*;

/**
 * @author kamildev7 on 2018-08-16.
 */
public class CategoryCommandToCategoryTest {

    public static final String DESCRIPTION = "description";
    public static final Long ID_VALUE = new Long(1L);

    CategoryCommandToCategory converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        CategoryCommand command = new CategoryCommand();
        command.setId(ID_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        Category category = converter.convert(command);

        //then
        assertNotNull(category);
        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}