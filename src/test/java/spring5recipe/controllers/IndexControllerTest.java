package spring5recipe.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import spring5recipe.domain.Recipe;
import spring5recipe.services.RecipeService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * @author kamildev7 on 2018-08-13.
 */
public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController indexController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {
        //given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());

        Recipe recipe = new Recipe();
        recipe.setId(1l);
        recipes.add(recipe);

        //when
        when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //then
        String viewName = indexController.getIndexPage(model);
        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }
}