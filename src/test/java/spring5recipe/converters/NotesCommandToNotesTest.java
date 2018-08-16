package spring5recipe.converters;

import org.junit.Before;
import org.junit.Test;
import spring5recipe.commands.NotesCommand;
import spring5recipe.domain.Notes;

import static org.junit.Assert.*;

/**
 * @author kamildev7 on 2018-08-16.
 */
public class NotesCommandToNotesTest {

    public static final String RECIPE_NOTES = "Notes";
    public static final Long ID_VALUE = new Long(1L);

    NotesCommandToNotes converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesCommandToNotes();
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        NotesCommand command = new NotesCommand();
        command.setId(ID_VALUE);
        command.setRecipeNotes(RECIPE_NOTES);

        //when
        Notes notes = converter.convert(command);

        //then
        assertNotNull(notes);
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
    }
}