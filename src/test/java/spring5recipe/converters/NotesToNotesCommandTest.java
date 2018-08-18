package spring5recipe.converters;

import org.junit.Before;
import org.junit.Test;
import spring5recipe.commands.NotesCommand;
import spring5recipe.domain.Notes;

import static org.junit.Assert.*;

/**
 * @author kamildev7 on 2018-08-16.
 */
public class NotesToNotesCommandTest {

    public static final String RECIPE_NOTES = "Notes";
    public static final String ID_VALUE = new String("1");

    NotesToNotesCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesToNotesCommand();
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Notes()));
    }

    @Test
    public void convert() throws Exception {
        //given
        Notes notes = new Notes();
        notes.setId(ID_VALUE);
        notes.setRecipeNotes(RECIPE_NOTES);

        //when
        NotesCommand command = converter.convert(notes);

        //then
        assertNotNull(command);
        assertEquals(ID_VALUE, command.getId());
        assertEquals(RECIPE_NOTES, command.getRecipeNotes());
    }
}