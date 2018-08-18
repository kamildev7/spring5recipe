package spring5recipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring5recipe.domain.Difficulty;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kamildev7 on 2018-08-14.
 */
@Setter
@Getter
@NoArgsConstructor
public class RecipeCommand {
    private String id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private NotesCommand notes;
    private Set<CategoryCommand> categories = new HashSet<>();
}
