package spring5recipe.services;

/**
 * @author kamildev7 on 2018-08-16.
 */
//public class IngredientServiceImplTest {
//
//    IngredientToIngredientCommand ingredientToIngredientCommand;
//    IngredientCommandToIngredient ingredientCommandToIngredient;
//
//    @Mock
//    RecipeRepository recipeRepository;
//
//    @Mock
//    UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;
//
//    @Mock
//    RecipeReactiveRepository recipeReactiveRepository;
//
//    IngredientService ingredientService;
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
//        ingredientCommandToIngredient = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
//        ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand,
//                ingredientCommandToIngredient, recipeReactiveRepository, recipeRepository, unitOfMeasureReactiveRepository);
//    }
//
//    @Test
//    public void findByRecipeIdAndIngredientId() {
//        //given
//        Recipe recipe = new Recipe();
//        recipe.setId("1");
//
//        Ingredient ingredient1 = new Ingredient();
//        ingredient1.setId("1");
//
//        Ingredient ingredient2 = new Ingredient();
//        ingredient2.setId("2");
//
//        Ingredient ingredient3 = new Ingredient();
//        ingredient3.setId("3");
//
//        recipe.addIngredient(ingredient1);
//        recipe.addIngredient(ingredient2);
//        recipe.addIngredient(ingredient3);
////        recipe.getIngredients().add(ingredient1);
////        recipe.getIngredients().add(ingredient2);
////        recipe.getIngredients().add(ingredient3);
//
//        Optional<Recipe> recipeOptional = Optional.of(recipe);
//
//        //when
//        when(recipeRepository.findById(anyString())).thenReturn(recipeOptional);
//        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId("1", "3").block();
//
//        //then
//        assertEquals("3", ingredientCommand.getId());
//        verify(recipeRepository, times(1)).findById(anyString());
//    }
//
//    @Test
//    public void saveIngredientCommand() {
//        //given
//        IngredientCommand command = new IngredientCommand();
//        command.setId("3");
//        command.setRecipeId("2");
//
//        Optional<Recipe> recipeOptional = Optional.of(new Recipe());
//
//        Recipe savedRecipe = new Recipe();
//        savedRecipe.addIngredient(new Ingredient());
//        savedRecipe.getIngredients().iterator().next().setId("3");
//
//        when(recipeRepository.findById(anyString())).thenReturn(recipeOptional);
//        when(recipeRepository.save(any())).thenReturn(savedRecipe);
//
//        //when
//        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command).block();
//
//        //then
//        assertEquals("3", savedCommand.getId());
//        verify(recipeRepository, times(1)).findById(anyString());
//        verify(recipeRepository, times(1)).save(any(Recipe.class));
//    }
//}